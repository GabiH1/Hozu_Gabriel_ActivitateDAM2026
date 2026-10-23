package com.example.seminar4_hozu_gabriel;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvRezultat;

    private final ActivityResultLauncher<Intent> addHangarLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Bundle bundle = result.getData().getExtras();
                    Hangar hangar = null;
                    if (bundle != null) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                            hangar = bundle.getSerializable("hangar_obj", Hangar.class);
                        } else {
                            hangar = (Hangar) bundle.getSerializable("hangar_obj");
                        }
                    }

                    if (hangar != null) {
                        String mesaj = hangar.toString();
                        tvRezultat.setText(mesaj);
                        Toast.makeText(MainActivity.this, "Obiect primit:\n" + mesaj, Toast.LENGTH_LONG).show();
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvRezultat = findViewById(R.id.tvRezultat);
        Button btnAdauga = findViewById(R.id.btnAdauga);

        btnAdauga.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddHangarActivity.class);
            addHangarLauncher.launch(intent);
        });
    }
}
