package com.example.test;

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

public class AddBicicletaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_bicicleta);

        Spinner spinnerMarca = findViewById(R.id.spinnerMarca);
        String[] marcas = {"Trek", "Cube", "Pegas"};
        ArrayAdapter<String> adapter= new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, marcas);
        spinnerMarca.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void salveazaBicicleta(View view) {
        EditText editTextId = findViewById(R.id.editTextId);
        EditText editTextModel = findViewById(R.id.editTextModel);
        EditText editTextPret = findViewById(R.id.editTextPret);
        RadioGroup radioGroupTip = findViewById(R.id.radioGroupTip);
        Spinner spinnerMarca = findViewById(R.id.spinnerMarca);
        CheckBox checkBoxElectrica = findViewById(R.id.checkBoxElectrica);
        Switch switchFraneDisc = findViewById(R.id.switchFraneDisc);
        RatingBar ratingBar = findViewById(R.id.ratingBar);

        int id = Integer.parseInt(editTextId.getText().toString());
        String model = editTextModel.getText().toString();
        float pret = Float.parseFloat(editTextPret.getText().toString());
        String tip = "";
        int selectedRadioButtonId = radioGroupTip.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
        tip=selectedRadioButton.getText().toString();
        String marca = spinnerMarca.getSelectedItem().toString();
        boolean esteElectrica = checkBoxElectrica.isChecked();
        boolean areFraneDisc = switchFraneDisc.isChecked();
        float rating = ratingBar.getRating();

        Bicicleta bicicleta = new Bicicleta(id, model, pret, tip, marca, esteElectrica, areFraneDisc, rating);

        Intent it = new Intent();
        Bundle b = new Bundle();
        b.putParcelable("bicicleta", bicicleta);
        it.putExtras(b);
        setResult(RESULT_OK, it);
        finish();

    }
}