package com.example.simularetest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddZborActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_zbor);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Spinner spinner = findViewById(R.id.spDestinatie);
        String destinatii[]={"Paris","Londra","Roma"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,destinatii);
        spinner.setAdapter(adapter);
    }

    public void SalveazaZbor(View view) {
        Intent intent=new Intent();
        Bundle bundle=new Bundle();
        EditText etCompanie=findViewById(R.id.etCompanie);
        EditText etNrLocuri=findViewById(R.id.etNrLocuri);
        CheckBox cbDirect=findViewById(R.id.cbDirect);
        Spinner spDestinatie=findViewById(R.id.spDestinatie);
        EditText etPret=findViewById(R.id.etPret);

        String nume=etCompanie.getText().toString();
        int nrLocuri=Integer.parseInt(etNrLocuri.getText().toString());
        boolean esteDirect=cbDirect.isChecked();
        String destinatie=spDestinatie.getSelectedItem().toString();
        float pret=Float.parseFloat(etPret.getText().toString());

        Zbor zbor=new Zbor(nume,nrLocuri,esteDirect,destinatie,pret);
        bundle.putParcelable("zbor",zbor);
        intent.putExtras(bundle);
        setResult(RESULT_OK,intent);
        finish();
    }
}