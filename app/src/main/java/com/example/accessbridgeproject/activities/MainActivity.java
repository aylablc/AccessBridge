package com.example.accessbridgeproject.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.example.accessbridgeproject.R;

public class MainActivity extends AppCompatActivity {

    CardView cardHealth, cardLegal, cardTransport, cardEducation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}