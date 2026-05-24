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

public class TransportActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_transport);

        btnBack = findViewById(R.id.btnBack);
        recyclerView = findViewById(R.id.recyclerViewTransport);
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
                searchTransport(query);
            }
        });
    }

    private void searchTransport(String query) {
        progressBar.setVisibility(View.VISIBLE);
        // BURAYA İETT API kodu gelecek
        // Retrofit ile istek atacak
        // Gelen veriyi itemList'e ekleyecek
        // adapter.notifyDataSetChanged() çağıracak
        // API entegrasyonu burada yapılacak
        // Arkadaşın bu metodu dolduracak
        // Şimdilik örnek veri gösteriyoruz

        itemList.clear();
        itemList.add(new InfoItem(
                "Bus Line 34",
                "Route: Taksim - Kadıköy\nFrequency: Every 10 minutes\nFirst: 06:00 Last: 23:00",
                "transport"
        ));
        itemList.add(new InfoItem(
                "Metro M2",
                "Route: Yenikapı - Hacıosman\nFrequency: Every 5 minutes\nFirst: 06:00 Last: 00:00",
                "transport"
        ));
        itemList.add(new InfoItem(
                "Bus Line 12",
                "Route: Beşiktaş - Eminönü\nFrequency: Every 15 minutes\nFirst: 07:00 Last: 22:00",
                "transport"
        ));

        adapter.notifyDataSetChanged();
        progressBar.setVisibility(View.GONE);
    }
}