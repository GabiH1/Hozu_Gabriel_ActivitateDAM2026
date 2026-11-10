package com.example.maimultaexersare;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
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


    List<Tableta> tablete = new ArrayList<>();

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

    public void DeschideAdaugaTableta(View view) {
        Intent intent = new Intent(getApplicationContext(), AddTableta.class);
        startActivityForResult(intent, 10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 && resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            Tableta tableta = bundle.getParcelable("tableta");
            tablete.add(tableta);
            Toast.makeText(getApplicationContext(), tableta.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void DeschideListaTablete(View view) {
        Intent intent = new Intent(getApplicationContext(), ListaTablete.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("tablete", (ArrayList<? extends Parcelable>) tablete);
        intent.putExtras(bundle);
        startActivityForResult(intent,20);
    }
}