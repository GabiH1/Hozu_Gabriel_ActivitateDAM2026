package com.example.exersare2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddHangar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_hangar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Spinner spinner = findViewById(R.id.spinner1);
        String locatii[] = {"Bucuresti", "Cluj", "Iasi"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, locatii);
        spinner.setAdapter(adapter);

        Intent it = getIntent();
        if (it != null && it.hasExtra("hangar")) {
            Hangar hangar = it.getParcelableExtra("hangar");
            if (hangar != null) {
                EditText etnume = findViewById(R.id.numeET);
                EditText etcapacitate = findViewById(R.id.capacitateET);
                CheckBox cb = findViewById(R.id.disponibilCB);
                RadioGroup rg = findViewById(R.id.RadioGrup);
                Spinner sp = findViewById(R.id.spinner1);
                RatingBar rb = findViewById(R.id.ratingBar);
                Switch sw = findViewById(R.id.switch1);

                etnume.setText(hangar.getNume());
                etcapacitate.setText(Integer.toString(hangar.getCapacitate()));
                cb.setChecked(hangar.isEsteDisponibil());
                if (hangar.getTip().equals("Avioane")) {
                    rg.check(R.id.avioaneRB);
                } else {
                    rg.check(R.id.elicoptereRB);
                }
                for (int i = 0; i < sp.getCount(); i++) {
                    if (sp.getItemAtPosition(i).equals(hangar.getLocatie())) {
                        sp.setSelection(i);
                        break;
                    }
                }
                rb.setRating(hangar.getRating());
                sw.setChecked(hangar.isArePaza());
            }
        }


    }

    public void SalveazaHangar(View view) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        EditText etnume = findViewById(R.id.numeET);
        EditText etcapacitate = findViewById(R.id.capacitateET);
        CheckBox cb = findViewById(R.id.disponibilCB);
        RadioGroup rg = findViewById(R.id.RadioGrup);
        Spinner sp = findViewById(R.id.spinner1);
        RatingBar rb = findViewById(R.id.ratingBar);
        Switch sw = findViewById(R.id.switch1);

        String nume = etnume.getText().toString();
        int capacitate = Integer.parseInt(etcapacitate.getText().toString());
        boolean esteDisponibil = cb.isChecked();
        int selectedId = rg.getCheckedRadioButtonId();
        RadioButton rb1 = findViewById(selectedId);
        String tip = "";
        if (rb1 != null) {
            tip = rb1.getText().toString();
        }
        String locatie = sp.getSelectedItem().toString();
        float rating = rb.getRating();
        boolean arePaza = sw.isChecked();

        bundle.putString("nume", nume);
        bundle.putInt("capacitate", capacitate);
        bundle.putBoolean("esteDisponibil", esteDisponibil);
        bundle.putString("tip", tip);
        bundle.putString("locatie", locatie);
        bundle.putFloat("rating", rating);
        bundle.putBoolean("arePaza", arePaza);
        Hangar hangar = new Hangar(nume, capacitate, esteDisponibil, tip, locatie, rating, arePaza);
        bundle.putParcelable("hangar", hangar);

        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        finish();

    }
}