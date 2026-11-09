package com.example.exersare2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class ListaHangare extends AppCompatActivity {

    private List<Hangar> hangare = null;
    private int idModificat = 0;
    private HangarAdapter adapter = null;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==10&&resultCode==RESULT_OK&&data!=null)
        {
            hangare.set(idModificat,data.getExtras().getParcelable("hangar"));
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_hangare);

        ListView lv = findViewById(R.id.listView);
        Intent it = getIntent();
        //ArrayList<Hangar> hangare = (ArrayList<Hangar>) it.getSerializableExtra("lista");
        hangare = it.getParcelableArrayListExtra("lista");
//        ArrayAdapter<Hangar> adapter = new ArrayAdapter<>(
//                getApplicationContext(),
//                android.R.layout.simple_list_item_1,
//                hangare
//        );
//        lv.setAdapter(adapter);

        adapter = new HangarAdapter(hangare, getApplicationContext(), R.layout.items_hangar);
        lv.setAdapter(adapter);


//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Hangar hangar = hangare.get(position);
//                Toast.makeText(ListaHangare.this, hangar.toString(), Toast.LENGTH_LONG).show();
//            }
//        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentModifica=new Intent(getApplicationContext(),AddHangar.class);
                intentModifica.putExtra("hangar", hangare.get(position));
                idModificat=position;
                startActivityForResult(intentModifica,10);
                Toast.makeText(getApplicationContext(),hangare.get(position).toString(),Toast.LENGTH_LONG).show();

            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Hangar hangar = hangare.get(position);
                hangare.remove(hangar);
                adapter.notifyDataSetChanged();

                Toast.makeText(ListaHangare.this, "Hangarul a fost stres", Toast.LENGTH_LONG).show();
                return true;
            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(

                findViewById(R.id.main), (v, insets) ->

                {
                    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                    return insets;
                });
    }
}