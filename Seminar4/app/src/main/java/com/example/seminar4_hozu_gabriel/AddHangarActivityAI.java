package com.example.seminar4_hozu_gabriel;

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

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddHangarActivityAI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_hangar_ai);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Spinner spLocatie = findViewById(R.id.spLocatie);
        String[] locatii = new String[]{"București", "Cluj-Napoca", "Timișoara", "Iași", "Constanța"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, locatii);
        spLocatie.setAdapter(adapter);
    }


    public void culegeDate(View view) {

        EditText etNume = findViewById(R.id.etNume);
        EditText etCapacitate = findViewById(R.id.etCapacitate);
        CheckBox cb = findViewById(R.id.cbDisponibil);
        RadioGroup rg = findViewById(R.id.rgTip);
        Spinner sp = findViewById(R.id.spLocatie);
        RatingBar rb = findViewById(R.id.rbRating);
        Switch sw = findViewById(R.id.swPaza);

        String nume = etNume.getText().toString();
        int capacitate = 0;
        try {
            capacitate = Integer.parseInt(etCapacitate.getText().toString());
        } catch (NumberFormatException e) {
            capacitate = 0;
        }

        Boolean esteDisponibil = cb.isChecked();

        int selectedRadioId = rg.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedRadioId);
        String tip = (selectedRadioButton != null) ? selectedRadioButton.getText().toString() : "Avioane";

        String locatie = sp.getSelectedItem() != null ? sp.getSelectedItem().toString() : "";
        Float rating = rb.getRating();
        Boolean arePaza = sw.isChecked();


        Bundle bundle = new Bundle();
        bundle.putString("nume", nume);
        bundle.putInt("capacitate", capacitate);
        bundle.putBoolean("esteDisponibil", esteDisponibil);
        bundle.putString("tip", tip);
        bundle.putString("locatie", locatie);
        bundle.putFloat("rating", rating);
        bundle.putBoolean("arePaza", arePaza);


        Intent it = new Intent();
        it.putExtras(bundle);

        setResult(RESULT_OK, it);
        finish();

    }
}
