package com.example.maps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class CuacaActivity extends AppCompatActivity {

    // Declare UI elements
    private ImageButton btnHome, btnCari, btnProfile;
    private CardView cardSearch, cardWeather;
    private LinearLayout layoutWeatherDetails;
    private TextView tvForecastTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuaca);
        btnHome = findViewById(R.id.btnHome);
        btnCari = findViewById(R.id.btnCari);
        btnProfile = findViewById(R.id.btnProfile);
        cardSearch = findViewById(R.id.cardSearch);
        cardWeather = findViewById(R.id.cardWeather);
        layoutWeatherDetails = findViewById(R.id.layoutWeatherDetails);
        tvForecastTitle = findViewById(R.id.tvForecastTitle);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CuacaActivity.this, Home.class);
                startActivity(intent);
            }
        });

        btnCari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CuacaActivity.this, Home.class);
                startActivity(intent);
            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CuacaActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        cardSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        cardWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                layoutWeatherDetails.setVisibility(View.VISIBLE);
            }
        });

        tvForecastTitle.setText("Prakiraan Cuaca");

    }
}
