package com.example.maps;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Home extends AppCompatActivity {

    private ImageButton btnHome, btnCari, btnProfile;
    private ImageView btnBookmark;
    private LinearLayout btnLokasi, btnGaleri, btnCuaca, btnTentang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnBookmark = findViewById(R.id.btnBookmark);
        btnHome = findViewById(R.id.btnHome);
        btnCari = findViewById(R.id.btnCari);
        btnProfile = findViewById(R.id.btnProfile);

        btnLokasi = findViewById(R.id.btnLokasi);
        btnGaleri = findViewById(R.id.btnGaleri);
        btnCuaca = findViewById(R.id.btnCuaca);
        btnTentang = findViewById(R.id.btnTentang);

        btnBookmark.setOnClickListener(v -> navigateToBookmark());
        btnHome.setOnClickListener(v -> navigateHome());
        btnCari.setOnClickListener(v -> navigateToSearch());
        btnProfile.setOnClickListener(v -> navigateToProfile());

        btnLokasi.setOnClickListener(v -> navigateToLokasi());
        btnGaleri.setOnClickListener(v -> navigateToGaleri());
        btnCuaca.setOnClickListener(v -> navigateToCuaca());
        btnTentang.setOnClickListener(v -> navigateToTentang());
    }
    private void navigateToBookmark() {
        Intent intent = new Intent(Home.this, BookmarkActivity.class);
        startActivity(intent);
    }
    private void navigateHome() {
        Toast.makeText(this, "Navigasi ke Home", Toast.LENGTH_SHORT).show();
    }
    private void navigateToSearch() {
        Intent intent = new Intent(Home.this, CariActivity.class);
        startActivity(intent);
    }
    private void navigateToProfile() {
        Intent intent = new Intent(Home.this, ProfileActivity.class);
        startActivity(intent);
    }
    private void navigateToLokasi() {
        Intent intent = new Intent(Home.this, LocationActivity.class);
        startActivity(intent);
    }
    private void navigateToGaleri() {
        Intent intent = new Intent(Home.this, GaleriActivity.class);
        startActivity(intent);
    }
    private void navigateToCuaca() {
        Intent intent = new Intent(Home.this, CuacaActivity.class);
        startActivity(intent);
    }
    private void navigateToTentang() {
        Intent intent = new Intent(Home.this, TentangActivity.class);
        startActivity(intent);
    }
}
