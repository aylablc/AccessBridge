package com.example.accessbridgeproject.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.accessbridgeproject.R;
import com.example.accessbridgeproject.adapters.InfoAdapter;
import com.example.accessbridgeproject.models.InfoItem;
import java.util.ArrayList;
import java.util.List;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import com.example.accessbridgeproject.utils.NetworkReceiver;

public class HealthActivity extends AppCompatActivity {
    private NetworkReceiver networkReceiver;
    private IntentFilter intentFilter;
    RecyclerView recyclerView;
    InfoAdapter adapter;
    List<InfoItem> itemList;
    TextView btnBack;
    AppCompatEditText etSearch;
    Button btnSearch;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);

        btnBack = findViewById(R.id.btnBack);
        recyclerView = findViewById(R.id.recyclerViewHealth);
        etSearch = findViewById(R.id.etSearch);
        btnSearch = findViewById(R.id.btnSearch);
        progressBar = findViewById(R.id.progressBar);

        btnBack.setOnClickListener(v -> finish());

        itemList = new ArrayList<>();

        adapter = new InfoAdapter(this, itemList, item -> {});

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        btnSearch.setOnClickListener(v -> {
            String query = etSearch.getText().toString().trim();
            if (!query.isEmpty()) {
                searchHealthFacilities(query);
            }
        });
        networkReceiver = new NetworkReceiver();
        intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(networkReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(networkReceiver);
    }
    private void searchHealthFacilities(String query) {
        progressBar.setVisibility(View.VISIBLE);
        // BURAYA Google Places API kodu gelecek
        // Retrofit ile istek atacak
        // Gelen veriyi itemList'e ekleyecek
        // adapter.notifyDataSetChanged() çağıracak
        // API entegrasyonu burada yapılacak
        // Arkadaşın bu metodu dolduracak
        // Şimdilik örnek veri gösteriyoruz

        itemList.clear();
        itemList.add(new InfoItem(
                "City Hospital",
                "Address: 123 Main St\nPhone: +90 212 555 0101\nOpen: 24/7",
                "health"
        ));
        itemList.add(new InfoItem(
                "Family Health Center",
                "Address: 45 Health Ave\nPhone: +90 212 555 0102\nOpen: 08:00 - 18:00",
                "health"
        ));
        itemList.add(new InfoItem(
                "Emergency Clinic",
                "Address: 78 Emergency Rd\nPhone: +90 212 555 0103\nOpen: 24/7",
                "health"
        ));

        adapter.notifyDataSetChanged();
        progressBar.setVisibility(View.GONE);
    }
}