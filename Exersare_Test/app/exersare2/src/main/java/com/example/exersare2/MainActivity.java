package com.example.exersare2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Hangar> hangare=new ArrayList<>();
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

    public void AdaugaHangar(View view) {
        Intent it=new Intent(this,AddHangar.class);
        Bundle bundle=new Bundle();
        bundle.putString("Mesaj","Salut din main");
        it.putExtras(bundle);
        startActivityForResult(it,10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==10&&resultCode==RESULT_OK&&data!=null)
        {
            Bundle bundle=data.getExtras();
            if(bundle!=null)
            {
                String nume = bundle.getString("nume");
                int capacitate = bundle.getInt("capacitate");
                boolean esteDisponibil = bundle.getBoolean("esteDisponibil");
                String tip = bundle.getString("tip");
                String locatie = bundle.getString("locatie");
                float rating = bundle.getFloat("rating");
                boolean arePaza = bundle.getBoolean("arePaza");

                Hangar hangar = new Hangar(nume, capacitate, esteDisponibil, tip, locatie, rating, arePaza);

                hangare.add(hangar);
                Toast.makeText(this,hangar.toString(),Toast.LENGTH_LONG).show();

                TextView tv=findViewById(R.id.textView);
                tv.setText(hangare.toString());
            }
        }
    }

    public void DeschideLisata(View view) {
        Intent it=new Intent(this,ListaHangare.class);
        Bundle bundle=new Bundle();
        bundle.putParcelableArrayList("lista",(ArrayList<Hangar>) hangare);
        it.putExtras(bundle);
        startActivityForResult(it,20);
    }
}