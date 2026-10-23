package com.example.seminar4_hozu_gabriel

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvRezultat: TextView

    private val addHangarLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK && result.data != null) {
            val bundle = result.data?.extras
            val hangar = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                bundle?.getSerializable("hangar_obj", Hangar::class.java)
            } else {
                @Suppress("DEPRECATION")
                bundle?.getSerializable("hangar_obj") as? Hangar
            }

            if (hangar != null) {
                val mesaj = hangar.toString()
                tvRezultat.text = mesaj
                Toast.makeText(this, "Obiect primit:\n$mesaj", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvRezultat = findViewById(R.id.tvRezultat)
        val btnAdauga = findViewById<Button>(R.id.btnAdauga)

        btnAdauga.setOnClickListener {
            val intent = Intent(this, AddHangarActivity::class.java)
            addHangarLauncher.launch(intent)
        }
    }
}
