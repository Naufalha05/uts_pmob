//LocationActivity.java
package com.example.maps;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LocationActivity extends AppCompatActivity {

    private ImageView bookmarkIcon;
    private LinearLayout infoLayout;
    private TextView locationName;

    private String currentFacultyId = ""; // untuk menyimpan ID fakultas yang sedang aktif
    private BookmarkDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        db = BookmarkDatabase.getInstance(this);

        // Inisialisasi UI umum
        infoLayout = findViewById(R.id.infoLayout);
        locationName = findViewById(R.id.locationName);
        bookmarkIcon = findViewById(R.id.bookmarkIcon);

        // Inisialisasi semua pin
        setupPin(R.id.pinFEIS, "FEIS UIN SUSKA RIAU", "FEIS");
        setupPin(R.id.pinFST, "FST UIN SUSKA RIAU", "FST");
        setupPin(R.id.pinFASILKOM, "FASILKOM UIN SUSKA RIAU", "FASILKOM");
        setupPin(R.id.pinFIK, "FIK UIN SUSKA RIAU", "FIK");
        setupPin(R.id.pinFEBI, "FEBI UIN SUSKA RIAU", "FEBI");
        setupPin(R.id.pinTARBIYAH, "TARBIYAH UIN SUSKA RIAU", "TARBIYAH");
        setupPin(R.id.pinDAKWAH, "DAKWAH UIN SUSKA RIAU", "DAKWAH");
        setupPin(R.id.pinSYARIAH, "SYARIAH & HUKUM UIN SUSKA RIAU", "SYARIAH");

        // Simpan ke bookmark
        bookmarkIcon.setOnClickListener(view -> {
            String name = locationName.getText().toString();
            if (!currentFacultyId.isEmpty() && !name.isEmpty()) {
                Bookmark bookmark = new Bookmark(name, currentFacultyId);
                db.bookmarkDao().insert(bookmark);
                Toast.makeText(this, "Bookmark ditambahkan!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupPin(int viewId, String locationTitle, String facultyId) {
        ImageView pin = findViewById(viewId);
        pin.setOnClickListener(v -> {
            locationName.setText(locationTitle);
            currentFacultyId = facultyId;
            infoLayout.setVisibility(View.VISIBLE);
        });
    }
}