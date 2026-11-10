package com.example.maimultaexersare;

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

import java.util.List;

public class ListaTablete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_tablete);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        List<Tableta> tablete = bundle.getParcelableArrayList("tablete");

        ListView lv = findViewById(R.id.Hozu_GabrielListView);
        TabletaAdapter adapter = new TabletaAdapter(getApplicationContext(), R.layout.item_tableta, tablete);
        lv.setAdapter(adapter);


        lv.setOnItemClickListener((parent, view, position, id) -> {
            Tableta tableta = tablete.get(position);
            Toast.makeText(getApplicationContext(), tableta.toString(), Toast.LENGTH_SHORT).show();

        });

        lv.setOnItemLongClickListener((parent, view, position, id) -> {
            Tableta tableta = tablete.get(position);
            tableta.setSpatiuMemorie((int) (tableta.getSpatiuMemorie() - 0.1 * tableta.getSpatiuMemorie()));
            adapter.notifyDataSetChanged();
            return true;
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}