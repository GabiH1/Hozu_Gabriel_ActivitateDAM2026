package com.example.simularetest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class ListaZboruri extends AppCompatActivity {

    List<Zbor> zboruri = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_zboruri);

        Intent it = getIntent();
        zboruri = it.getParcelableArrayListExtra("lista");

        ListView lv = findViewById(R.id.listView);
//        ArrayAdapter<Zbor> adapter=new ArrayAdapter<>(
//                getApplicationContext(),
//                android.R.layout.simple_list_item_1,
//                zboruri
//        );
//        lv.setAdapter(adapter);

        ZborAdapter adapter = new ZborAdapter(zboruri, getApplicationContext(), R.layout.item_zbor);
        lv.setAdapter(adapter);

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Zbor zbor=zboruri.get(position);
                zboruri.remove(zbor);
                adapter.notifyDataSetChanged();
                Toast.makeText(ListaZboruri.this,"Zborul a fost stres", Toast.LENGTH_LONG).show();
                return true;
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}