package com.example.seminar4_hozu_gabriel;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class lista_hangare extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_hangare);

        ListView lv = findViewById(R.id.lwHangare);

        Intent intent = getIntent();
        ArrayList<Hangar> hangare = (ArrayList<Hangar>) intent.getSerializableExtra("hangare");

        if (hangare != null) {
            ArrayAdapter<Hangar> adapter = new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_list_item_1,
                    hangare
            );
            lv.setAdapter(adapter);
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}