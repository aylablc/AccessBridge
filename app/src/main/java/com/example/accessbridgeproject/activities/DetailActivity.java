package com.example.accessbridgeproject.activities;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.accessbridgeproject.R;

public class DetailActivity extends AppCompatActivity {

    TextView tvTitle, tvDescription, tvToolbarTitle, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvTitle = findViewById(R.id.tvTitle);
        tvDescription = findViewById(R.id.tvDescription);
        tvToolbarTitle = findViewById(R.id.tvToolbarTitle);
        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(v -> finish());

        String title = getIntent().getStringExtra("title");
        String description = getIntent().getStringExtra("description");
        String category = getIntent().getStringExtra("category");

        tvTitle.setText(title);
        tvDescription.setText(description);
        tvToolbarTitle.setText(category);
    }
}