package com.example.maps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class GaleriActivity extends AppCompatActivity {
    private ImageButton btnHome, btnCari, btnProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeri);
        btnHome = findViewById(R.id.btnHome);
        btnCari = findViewById(R.id.btnCari);
        btnProfile = findViewById(R.id.btnProfile);
        CardView card1 = findViewById(R.id.card1);
        CardView card2 = findViewById(R.id.card2);
        CardView card3 = findViewById(R.id.card3);
        CardView card4 = findViewById(R.id.card4);
        CardView card5 = findViewById(R.id.card5);
        CardView card6 = findViewById(R.id.card6);
        CardView card7 = findViewById(R.id.card7);
        CardView card8 = findViewById(R.id.card8);


        LinearLayout info1 = findViewById(R.id.info1);
        LinearLayout info2 = findViewById(R.id.info2);
        LinearLayout info3 = findViewById(R.id.info3);
        LinearLayout info4 = findViewById(R.id.info4);
        LinearLayout info5 = findViewById(R.id.info5);
        LinearLayout info6 = findViewById(R.id.info6);
        LinearLayout info7 = findViewById(R.id.info7);
        LinearLayout info8 = findViewById(R.id.info8);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleInfo(info1);
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleInfo(info2);
            }
        });
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleInfo(info3);
            }
        });
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleInfo(info4);
            }
        });
        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleInfo(info5);
            }
        });
        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleInfo(info6);
            }
        });
        card7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleInfo(info7);
            }
        });
        card8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleInfo(info8);
            }
        });
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GaleriActivity.this, Home.class);
                startActivity(intent);
            }
        });

        btnCari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GaleriActivity.this, Home.class);
                startActivity(intent);
            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GaleriActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }

    private void toggleInfo(LinearLayout infoLayout) {
        if (infoLayout.getVisibility() == View.VISIBLE) {
            infoLayout.setVisibility(View.GONE);
        } else {
            infoLayout.setVisibility(View.VISIBLE);
        }
    }
}
