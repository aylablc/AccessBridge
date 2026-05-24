package com.example.accessbridgeproject.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.accessbridgeproject.R;
import com.example.accessbridgeproject.adapters.InfoAdapter;
import com.example.accessbridgeproject.models.InfoItem;
import java.util.ArrayList;
import java.util.List;

public class LegalActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    InfoAdapter adapter;
    List<InfoItem> itemList;
    TextView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legal);

        btnBack = findViewById(R.id.btnBack);
        recyclerView = findViewById(R.id.recyclerViewLegal);

        btnBack.setOnClickListener(v -> finish());

        itemList = new ArrayList<>();
        loadLegalRights();

        adapter = new InfoAdapter(this, itemList, item -> {
            Intent intent = new Intent(LegalActivity.this, DetailActivity.class);
            intent.putExtra("title", item.getTitle());
            intent.putExtra("description", item.getDescription());
            intent.putExtra("category", item.getCategory());
            startActivity(intent);
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void loadLegalRights() {
        itemList.add(new InfoItem(
                "Right to Health",
                "Everyone has the right to access healthcare services. You can receive free emergency care at public hospitals regardless of your status.",
                "legal"
        ));
        itemList.add(new InfoItem(
                "Right to Education",
                "Every child has the right to free and compulsory education. No child can be denied access to education.",
                "legal"
        ));
        itemList.add(new InfoItem(
                "Right to Housing",
                "Everyone has the right to adequate housing. You can apply for social housing if you are in need.",
                "legal"
        ));
        itemList.add(new InfoItem(
                "Right to Legal Aid",
                "If you cannot afford a lawyer, you have the right to free legal assistance through legal aid services.",
                "legal"
        ));
        itemList.add(new InfoItem(
                "Right to Work",
                "Every person has the right to work and fair wages. Discrimination in the workplace is prohibited by law.",
                "legal"
        ));
        itemList.add(new InfoItem(
                "Right to Social Support",
                "If you are in financial difficulty, you can apply for social assistance from local municipalities.",
                "legal"
        ));
    }
}