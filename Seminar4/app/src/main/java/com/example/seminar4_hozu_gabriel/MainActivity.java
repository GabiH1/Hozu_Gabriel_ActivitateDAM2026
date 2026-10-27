package com.example.seminar4_hozu_gabriel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void deschideActivitateAdaugare(View view) {

        Intent it = new Intent(this, AddHangarActivity.class);
        startActivityForResult(it , 10);



    }

    public void deschideActivitateAdaugareAI(View view) {
        Intent it = new Intent(this, AddHangarActivityAI.class);
        startActivityForResult(it, 20);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if((requestCode == 10 || requestCode == 20) && resultCode == RESULT_OK && data != null){

            Bundle bundle = data.getExtras();

            if (bundle != null) {
                String nume = bundle.getString("nume");
                int capacitate = bundle.getInt("capacitate");
                boolean esteDisponibil = bundle.getBoolean("esteDisponibil");
                String tip = bundle.getString("tip");
                String locatie = bundle.getString("locatie");
                float rating = bundle.getFloat("rating");
                boolean arePaza = bundle.getBoolean("arePaza");

                Hangar hangar = new Hangar(nume, capacitate, esteDisponibil, tip, locatie, rating, arePaza);

                TextView tv = findViewById(R.id.textView);
                tv.setText(hangar.toString());
            }

        }


    }
}
