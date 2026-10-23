package com.example.seminar4_hozu_gabriel

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.RatingBar
import android.widget.Spinner
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity

class AddHangarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_hangar)

        val etNume = findViewById<EditText>(R.id.etNume)
        val etCapacitate = findViewById<EditText>(R.id.etCapacitate)
        val cbDisponibil = findViewById<CheckBox>(R.id.cbDisponibil)
        val rgTip = findViewById<RadioGroup>(R.id.rgTip)
        val spLocatie = findViewById<Spinner>(R.id.spLocatie)
        val rbRating = findViewById<RatingBar>(R.id.rbRating)
        val swPaza = findViewById<Switch>(R.id.swPaza)
        val btnSalveaza = findViewById<Button>(R.id.btnSalveaza)

        val locatii = arrayOf("București", "Cluj-Napoca", "Timișoara", "Iași", "Constanța")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, locatii)
        spLocatie.adapter = adapter

        btnSalveaza.setOnClickListener {
            val nume = etNume.text.toString().trim()
            val capacitateStr = etCapacitate.text.toString().trim()

            if (nume.isEmpty()) {
                etNume.error = "Introduceți numele hangarului"
                return@setOnClickListener
            }

            if (capacitateStr.isEmpty()) {
                etCapacitate.error = "Introduceți capacitatea"
                return@setOnClickListener
            }

            val capacitate = capacitateStr.toIntOrNull() ?: 0
            val esteDisponibil = cbDisponibil.isChecked

            val selectedRadioId = rgTip.checkedRadioButtonId
            val selectedRadioButton = findViewById<RadioButton>(selectedRadioId)
            val tip = selectedRadioButton?.text?.toString() ?: "Avioane"

            val locatie = spLocatie.selectedItem.toString()
            val rating = rbRating.rating
            val arePaza = swPaza.isChecked

            val hangar = Hangar(
                nume = nume,
                capacitate = capacitate,
                esteDisponibil = esteDisponibil,
                tip = tip,
                locatie = locatie,
                rating = rating,
                arePaza = arePaza
            )

            val intent = Intent()
            val bundle = Bundle()
            bundle.putSerializable("hangar_obj", hangar)
            intent.putExtras(bundle)

            setResult(RESULT_OK, intent)
            finish()
        }
    }
}
