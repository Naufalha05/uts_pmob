package com.example.maps;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private TextView errorText, forgotPasswordText;
    private ImageView passwordToggle;
    private MaterialButton loginButton, registerButton, guestButton;
    private boolean isPasswordVisible = false;

    private SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "UserPrefs";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inisialisasi View
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        passwordToggle = findViewById(R.id.passwordToggle);
        errorText = findViewById(R.id.errorText);
        loginButton = findViewById(R.id.loginButton);
        registerButton = findViewById(R.id.registerButton);
        guestButton = findViewById(R.id.guestButton);
        forgotPasswordText = findViewById(R.id.forgotPasswordText);

        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        passwordToggle.setOnClickListener(v -> togglePasswordVisibility());
        loginButton.setOnClickListener(v -> {
                    startActivity(new Intent(LoginActivity.this, Home.class));
                });
        registerButton.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, DaftarActivity.class));
        });
        guestButton.setOnClickListener(v -> {
            Toast.makeText(this, "Masuk sebagai Tamu", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity.this, GuessHome.class));
        });
        forgotPasswordText.setOnClickListener(v -> {
            Toast.makeText(this, "Fitur lupa password belum tersedia", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity.this, ResetActivity.class));
        });
    }

    private void togglePasswordVisibility() {
        if (isPasswordVisible) {
            passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            passwordToggle.setImageResource(R.drawable.ic_eye_off);
        } else {
            passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            passwordToggle.setImageResource(R.drawable.ic_eye);
        }
        passwordEditText.setSelection(passwordEditText.length());
        isPasswordVisible = !isPasswordVisible;
    }

    private void handleLogin() {
        String emailInput = emailEditText.getText().toString().trim();
        String passwordInput = passwordEditText.getText().toString().trim();

        if (emailInput.isEmpty() || passwordInput.isEmpty()) {
            errorText.setVisibility(View.VISIBLE);
            errorText.setText("Email dan password tidak boleh kosong.");
            return;
        }

        // Ambil email & password yang sudah disimpan
        String savedEmail = sharedPreferences.getString(KEY_EMAIL, "");
        String savedPassword = sharedPreferences.getString(KEY_PASSWORD, "");

        if (emailInput.equals(savedEmail) && passwordInput.equals(savedPassword)) {
            errorText.setVisibility(View.GONE);
            Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show();
            // TODO: Setelah login berhasil, pindah ke halaman utama
            // startActivity(new Intent(this, MainActivity.class));
        } else {
            errorText.setVisibility(View.VISIBLE);
            errorText.setText("Email atau password salah.");
        }
    }
}