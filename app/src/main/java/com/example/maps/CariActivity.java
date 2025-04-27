package com.example.maps;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maps.adapter.FileAdapter;
import com.example.maps.model.FileItem;

import java.util.ArrayList;
import java.util.List;

public class CariActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FileAdapter fileAdapter;
    private EditText editSearch;
    private ImageButton btnSearch;

    // Tambahan untuk bottom navigation
    private ImageButton btnHome, btnCari, btnProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari);

        // Initialize views
        recyclerView = findViewById(R.id.recycler_files);
        editSearch = findViewById(R.id.edit_search);
        btnSearch = findViewById(R.id.btn_search);

        // Initialize bottom navigation buttons
        btnHome = findViewById(R.id.btnHome);
        btnCari = findViewById(R.id.btnCari);
        btnProfile = findViewById(R.id.btnProfile);

        // Set up RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fileAdapter = new FileAdapter(this, getDataFromGaleri());
        recyclerView.setAdapter(fileAdapter);

        // Set up search button
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performSearch();
            }
        });

        // Set up keyboard search action
        editSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    performSearch();
                    return true;
                }
                return false;
            }
        });

        // Set up bottom navigation actions
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CariActivity.this, Home.class);
                startActivity(intent);
                finish();
            }
        });

        btnCari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CariActivity.this, ProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void performSearch() {
        String query = editSearch.getText().toString().trim();
        fileAdapter.filter(query);

        // Hide keyboard after search
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(editSearch.getWindowToken(), 0);
        }
    }

    private List<FileItem> getDataFromGaleri() {
        List<FileItem> fileItems = new ArrayList<>();

        fileItems.add(new FileItem(
                "Fakultas Tarbiyah dan Keguruan",
                false,
                "Fakultas",
                "Pendidikan",
                R.drawable.tarbiyah,
                R.id.card1,
                "Fakultas Tarbiyah dan Keguruan (FTK) Universitas Islam Negeri Sultan Syarif Kasim Riau (UIN Suska Riau) merupakan fakultas tertua di lingkungan universitas ini. Fakultas ini bertanggung jawab dalam mempersiapkan calon guru yang kompeten, baik dalam bidang agama maupun umum. Dalam lima tahun terakhir, FTK telah berhasil mewisuda rata-rata 500 calon guru setiap tahunnya, yang siap berkontribusi dalam mencerdaskan bangsa, khususnya di Provinsi Riau dan Indonesia secara umum."
        ));

        fileItems.add(new FileItem(
                "Fakultas Syariah dan Hukum",
                false,
                "Fakultas",
                "Hukum",
                R.drawable.syar,
                R.id.card2,
                "Fakultas ini mengkhususkan diri dalam bidang hukum Islam dan perundang-undangan yang terkait. Program studi yang tersedia termasuk Ilmu Hukum, Hukum Ekonomi Islam, dan Hukum Keluarga Islam. Fakultas ini bertujuan untuk menghasilkan ahli hukum yang menguasai hukum Islam dan hukum positif dengan wawasan global."
        ));

        fileItems.add(new FileItem(
                "Fakultas Ushuluddin",
                false,
                "Fakultas",
                "Agama",
                R.drawable.ushu,
                R.id.card3,
                "Fakultas Ushuluddin mempelajari dasar-dasar ajaran agama Islam, meliputi Aqidah, Filsafat, Tafsir, Hadis, dan Perbandingan Agama. Fakultas ini bertujuan untuk menghasilkan lulusan yang memiliki pemahaman mendalam tentang agama Islam dan mampu berdialog dengan berbagai pemikiran dan keyakinan agama lain."
        ));

        fileItems.add(new FileItem(
                "Fakultas Dakwah dan Komunikasi",
                false,
                "Fakultas",
                "Komunikasi",
                R.drawable.dak,
                R.id.card4,
                "Fakultas ini berfokus pada pengembangan komunikasi dakwah dan media. Program studi yang tersedia mencakup Ilmu Komunikasi, Penyiaran Islam, dan Jurnalistik Islam. Fakultas ini bertujuan untuk mencetak para komunikator dan jurnalis yang berbasis nilai Islam dan profesional dalam penyebaran informasi."
        ));

        fileItems.add(new FileItem(
                "Fakultas Ekonomi dan Ilmu Sosial",
                false,
                "Fakultas",
                "Ekonomi",
                R.drawable.sos,
                R.id.card5,
                "Fakultas ini menawarkan program-program studi yang berkaitan dengan ilmu ekonomi dan ilmu sosial, seperti Manajemen, Akuntansi, dan Ilmu Komunikasi. Tujuan dari fakultas ini adalah untuk mencetak profesional yang mampu mengelola ekonomi dengan pendekatan yang berlandaskan pada prinsip-prinsip Islam, serta berkontribusi pada pembangunan sosial."
        ));

        fileItems.add(new FileItem(
                "Fakultas Psikologi",
                false,
                "Fakultas",
                "Psikologi",
                R.drawable.psi,
                R.id.card6,
                "Fakultas Psikologi mempelajari aspek psikologi manusia, baik dari segi perkembangan, sosial, kesehatan, hingga psikologi pendidikan. Fakultas ini bertujuan untuk mencetak ahli psikologi yang mampu memberikan solusi dalam berbagai masalah psikologis dengan pendekatan ilmiah yang berlandaskan pada nilai-nilai Islam."
        ));

        fileItems.add(new FileItem(
                "Fakultas Sains dan Teknologi",
                false,
                "Fakultas",
                "Teknologi",
                R.drawable.tek,
                R.id.card7,
                "Fakultas ini menawarkan program studi yang mencakup bidang sains dan teknologi, seperti Matematika, Sistem Informasi, Teknik Elektro, Teknik Informatika, dan Teknik Industri. Fakultas ini bertujuan untuk menghasilkan lulusan yang memiliki kompetensi tinggi dalam teknologi dan sains serta mampu mengintegrasikannya dengan nilai-nilai Islam untuk memberikan manfaat kepada umat."
        ));

        fileItems.add(new FileItem(
                "Fakultas Pertanian dan Peternakan",
                false,
                "Fakultas",
                "Pertanian",
                R.drawable.peter,
                R.id.card8,
                "Fakultas ini memiliki program studi yang berfokus pada bidang pertanian dan peternakan, termasuk Agroteknologi, Peternakan, dan Gizi. Fakultas ini bertujuan untuk menghasilkan lulusan yang memiliki kemampuan untuk mengelola sektor pertanian dan peternakan dengan berbasis pada prinsip keberlanjutan dan nilai-nilai Islam."
        ));

        return fileItems;
    }
}
