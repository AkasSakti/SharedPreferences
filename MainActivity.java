package com.example.sharedprefs;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etUsername;
    private Button btnSave, btnLoad, btnDelete;
    private TextView tvResult;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);
        btnDelete = findViewById(R.id.btnDelete);
        tvResult = findViewById(R.id.tvResult);

        // Inisialisasi SharedPreferences
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        // Tombol Simpan
        btnSave.setOnClickListener(view -> {
            String username = etUsername.getText().toString();
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("username", username);
            editor.apply();
            etUsername.setText("");
        });

        // Tombol Baca
        btnLoad.setOnClickListener(view -> {
            String username = sharedPreferences.getString("username", "Default User");
            tvResult.setText("Username: " + username);
        });

        // Tombol Hapus
        btnDelete.setOnClickListener(view -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.remove("username");
            editor.apply();
            tvResult.setText("Data telah dihapus");
        });
    }
}
