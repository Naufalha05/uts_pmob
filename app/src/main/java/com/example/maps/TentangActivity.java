package com.example.maps;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;
import com.google.android.material.button.MaterialButton;
import androidx.appcompat.app.AppCompatActivity;

public class TentangActivity extends AppCompatActivity {

    ImageButton btnHome, btnCari, btnProfile;
    MaterialButton instagramBtn1, instagramBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang);

        btnHome = findViewById(R.id.btnHome);
        btnCari = findViewById(R.id.btnCari);
        btnProfile = findViewById(R.id.btnProfile);

        instagramBtn1 = findViewById(R.id.instagramBtn1);
        instagramBtn2 = findViewById(R.id.instagramBtn2);

        btnHome.setOnClickListener(view -> {
            Intent intent = new Intent(TentangActivity.this, Home.class);
            startActivity(intent);
        });

        btnCari.setOnClickListener(view -> {
            Intent intent = new Intent(TentangActivity.this, Home.class);
            startActivity(intent);
        });

        btnProfile.setOnClickListener(view -> {
            Intent intent = new Intent(TentangActivity.this, ProfileActivity.class);
            startActivity(intent);

        });

        instagramBtn1.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/ndrethrten?igsh=MjRvaDA0bmJ6dnox"));
            startActivity(intent);
        });

        instagramBtn2.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/nhidayatul_a?igsh=MTM3ZWl3Zmo0Zjhraw=="));
            startActivity(intent);
        });
    }
}
