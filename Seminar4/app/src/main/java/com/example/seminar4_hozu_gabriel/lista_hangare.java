package com.example.seminar4_hozu_gabriel;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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

            // 3. Afisare Toast la selectarea unui element din ListView
            lv.setOnItemClickListener((parent, view, position, id) -> {
                Hangar hangar = hangare.get(position);
                Toast.makeText(getApplicationContext(), hangar.toString(), Toast.LENGTH_SHORT).show();
            });

            // 4. Stergere element la LongItemClick din ListView si din lista
            lv.setOnItemLongClickListener((parent, view, position, id) -> {
                hangare.remove(position);
                adapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), "Obiect sters!", Toast.LENGTH_SHORT).show();

                Intent resultIntent = new Intent();
                resultIntent.putExtra("hangare_upd", hangare);
                setResult(RESULT_OK, resultIntent);

                return true;
            });
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
