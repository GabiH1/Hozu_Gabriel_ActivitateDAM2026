package com.example.seminar4_hozu_gabriel;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class AddHangarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_hangar);

        EditText etNume = findViewById(R.id.etNume);
        EditText etCapacitate = findViewById(R.id.etCapacitate);
        CheckBox cbDisponibil = findViewById(R.id.cbDisponibil);
        RadioGroup rgTip = findViewById(R.id.rgTip);
        Spinner spLocatie = findViewById(R.id.spLocatie);
        RatingBar rbRating = findViewById(R.id.rbRating);
        Switch swPaza = findViewById(R.id.swPaza);
        Button btnSalveaza = findViewById(R.id.btnSalveaza);

        String[] locatii = new String[]{"București", "Cluj-Napoca", "Timișoara", "Iași", "Constanța"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, locatii);
        spLocatie.setAdapter(adapter);

        btnSalveaza.setOnClickListener(v -> {
            String nume = etNume.getText().toString().trim();
            String capacitateStr = etCapacitate.getText().toString().trim();

            if (nume.isEmpty()) {
                etNume.setError("Introduceți numele hangarului");
                return;
            }

            if (capacitateStr.isEmpty()) {
                etCapacitate.setError("Introduceți capacitatea");
                return;
            }

            int capacitate;
            try {
                capacitate = Integer.parseInt(capacitateStr);
            } catch (NumberFormatException e) {
                capacitate = 0;
            }

            boolean esteDisponibil = cbDisponibil.isChecked();

            int selectedRadioId = rgTip.getCheckedRadioButtonId();
            RadioButton selectedRadioButton = findViewById(selectedRadioId);
            String tip = (selectedRadioButton != null) ? selectedRadioButton.getText().toString() : "Avioane";

            String locatie = spLocatie.getSelectedItem().toString();
            float rating = rbRating.getRating();
            boolean arePaza = swPaza.isChecked();

            Hangar hangar = new Hangar(
                    nume,
                    capacitate,
                    esteDisponibil,
                    tip,
                    locatie,
                    rating,
                    arePaza
            );

            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("hangar_obj", hangar);
            intent.putExtras(bundle);

            setResult(RESULT_OK, intent);
            finish();
        });
    }
}
