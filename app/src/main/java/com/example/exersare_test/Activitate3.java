package com.example.exersare_test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activitate3 extends AppCompatActivity {

    private String mesajprimit;
    private int val1;
    private int val2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activitate3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent intent=getIntent();
        if(intent!=null&&intent.getExtras()!=null){
            Bundle bundle=intent.getExtras();
            mesajprimit=bundle.getString("Mesaj","");
            val1=bundle.getInt("Val1",0);
            val2=bundle.getInt("Val2",0);
            Toast.makeText(this,"Mesaj"+mesajprimit+" Val1 "+val1+" Val2 "+val2,Toast.LENGTH_LONG).show();
        }
    }

    public void intoarcereActivitate2(View view) {
        int suma=val1+val2;
        Intent it=new Intent();
        Bundle bundle=new Bundle();
        bundle.putString("Mesaj","Calcul efectuat cu succes");
        bundle.putInt("Suma",suma);
        it.putExtras(bundle);
        setResult(RESULT_OK,it);
        finish();
    }
}