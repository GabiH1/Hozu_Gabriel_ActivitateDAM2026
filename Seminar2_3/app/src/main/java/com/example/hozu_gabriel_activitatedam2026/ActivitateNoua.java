package com.example.hozu_gabriel_activitatedam2026;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivitateNoua extends AppCompatActivity {

    private static final int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activitate_noua);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Log.v("Seminar", "ActivitateNoua onCreate");
    }

    public void deschideActivitate(View view) {
        Intent it = new Intent(this, ActivitateRezultat.class);
        Bundle bundle = new Bundle();
        bundle.putString("MESAJ", "Salut din ActivitateNoua!");
        bundle.putInt("VAL1", 15);
        bundle.putInt("VAL2", 25);
        it.putExtras(bundle);

        startActivityForResult(it, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            Bundle bundle = data.getExtras();
            if (bundle != null) {
                String mesaj = bundle.getString("MESAJ_REZULTAT", "");
                int suma = bundle.getInt("SUMA", 0);
                Toast.makeText(this,
                        "Mesaj primit: " + mesaj + "\nSuma calculata: " + suma,
                        Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Seminar", "ActivitateNoua onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Seminar", "ActivitateNoua onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w("Seminar", "ActivitateNoua onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Seminar", "ActivitateNoua onStop");
    }
}
