package com.example.maps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private ImageButton btnHome, btnCari, btnProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile); // Ganti sesuai nama file XML kamu


        btnHome = findViewById(R.id.btnHome);
        btnCari = findViewById(R.id.btnCari);
        btnProfile = findViewById(R.id.btnProfile);


        btnHome.setOnClickListener(v -> {
            Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
             startActivity(new Intent(this, Home.class));
        });

        btnCari.setOnClickListener(v -> { //ini ubah nnti ke search
            Toast.makeText(this, "Cari", Toast.LENGTH_SHORT).show();
             startActivity(new Intent(this, Home.class));
        });

        btnProfile.setOnClickListener(v -> {
            Toast.makeText(this, "Kamu sudah di halaman Profil", Toast.LENGTH_SHORT).show();
        });


        findViewById(R.id.logout).setOnClickListener(v -> {
            Toast.makeText(this, "Logout berhasil", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });
    }
}
