package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class ListaBicicleteActivity extends AppCompatActivity {

    List<Bicicleta> biciclete = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_biciclete);

        Intent it = getIntent();
        Bundle b = it.getExtras();
        biciclete = b.getParcelableArrayList("biciclete");

        ListView listView = findViewById(R.id.listView);
        BicicletaAdapter adapter = new BicicletaAdapter(biciclete, this, R.layout.item_bicicleta);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener((parent, view, position, id) -> {
            Bicicleta bicicleta = biciclete.get(position);
            Toast.makeText(this, bicicleta.toString(), Toast.LENGTH_SHORT).show();
                });

        listView.setOnItemLongClickListener((parent, view, position, id) -> {
                    Bicicleta bicicleta=biciclete.get(position);
                    bicicleta.setPret(0.85f*bicicleta.getPret());
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