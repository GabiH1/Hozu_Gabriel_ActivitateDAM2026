package com.example.hozu_gabriel_activitatedam2026;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivitateRezultat extends AppCompatActivity {

    private int val1 = 0;
    private int val2 = 0;
    private String mesajPrimit = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activitate_rezultat);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        if (intent != null && intent.getExtras() != null) {
            Bundle bundle = intent.getExtras();
            mesajPrimit = bundle.getString("MESAJ", "");
            val1 = bundle.getInt("VAL1", 0);
            val2 = bundle.getInt("VAL2", 0);

            Toast.makeText(this, "Mesaj: " + mesajPrimit + "\nVal1: " + val1 + ", Val2: " + val2, Toast.LENGTH_LONG).show();
        }

        Log.v("Seminar", "ActivitateRezultat onCreate");
    }

    public void trimiteRezultat(View view) {
        int suma = val1 + val2;
        Intent intentRezultat = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("MESAJ_REZULTAT", "Suma calculata din ActivitateRezultat");
        bundle.putInt("SUMA", suma);
        intentRezultat.putExtras(bundle);
        setResult(RESULT_OK, intentRezultat);
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Seminar", "ActivitateRezultat onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Seminar", "ActivitateRezultat onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w("Seminar", "ActivitateRezultat onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Seminar", "ActivitateRezultat onStop");
    }
}
