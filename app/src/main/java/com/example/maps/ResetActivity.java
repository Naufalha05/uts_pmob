package com.example.maps;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ResetActivity extends AppCompatActivity {

    private EditText emailEditText;
    private LinearLayout sendResetButton;
    private ProgressBar resetProgressBar;
    private TextView resetFeedback;
    private TextView backToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);

        // Inisialisasi view
        emailEditText = findViewById(R.id.emailEditText);
        sendResetButton = findViewById(R.id.sendResetButton);
        resetProgressBar = findViewById(R.id.resetProgressBar);
        resetFeedback = findViewById(R.id.resetFeedback);
        backToLogin = findViewById(R.id.backToLogin);

        // Aksi tombol kirim
        sendResetButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString().trim();

            if (TextUtils.isEmpty(email)) {
                resetFeedback.setText("Email tidak boleh kosong");
                resetFeedback.setVisibility(View.VISIBLE);
            } else {
                resetFeedback.setVisibility(View.GONE);
                resetProgressBar.setVisibility(View.VISIBLE);

                // Simulasi proses pengiriman email reset password
                emailEditText.postDelayed(() -> {
                    resetProgressBar.setVisibility(View.GONE);
                    Toast.makeText(ResetActivity.this, "Link reset telah dikirim ke " + email, Toast.LENGTH_LONG).show();
                }, 2000); // delay 2 detik untuk simulasi
            }
        });

        // Aksi teks "Back to Login"
        backToLogin.setOnClickListener(v -> {
            Intent intent = new Intent(ResetActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }
}