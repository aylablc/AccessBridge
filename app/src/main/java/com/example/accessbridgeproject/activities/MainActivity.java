package com.example.accessbridgeproject.activities;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import com.example.accessbridgeproject.R;

public class MainActivity extends AppCompatActivity {

    CardView cardHealth, cardLegal, cardTransport, cardEducation;
    private static final String CHANNEL_ID = "accessbridge_channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createNotificationChannel();
        showWelcomeNotification();

        cardHealth = findViewById(R.id.cardHealth);
        cardLegal = findViewById(R.id.cardLegal);
        cardTransport = findViewById(R.id.cardTransport);
        cardEducation = findViewById(R.id.cardEducation);

        cardHealth.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, HealthActivity.class);
            startActivity(intent);
        });

        cardLegal.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LegalActivity.class);
            startActivity(intent);
        });

        cardTransport.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TransportActivity.class);
            startActivity(intent);
        });

        cardEducation.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, EducationActivity.class);
            startActivity(intent);
        });
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "AccessBridge Bildirimleri",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            channel.setDescription("AccessBridge uygulama bildirimleri");
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }

    private void showWelcomeNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("AccessBridge'e Hoş Geldiniz!")
                .setContentText("Sağlık, hukuk, ulaşım ve eğitim bilgilerine ulaşın.")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true);

        NotificationManager manager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        manager.notify(1, builder.build());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_about) {
            Toast.makeText(t