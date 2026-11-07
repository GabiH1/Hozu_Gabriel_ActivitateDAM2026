package com.example.exersare_test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activitate2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activitate2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void deschideActivitatea3(View view) {
        Intent it = new Intent(this, Activitate3.class);
        Bundle bundle = new Bundle();
        bundle.putString("Mesaj", "Salut din activitatea 2");
        bundle.putInt("Val1", 15);
        bundle.putInt("Val2", 20);
        it.putExtras(bundle);
        startActivityForResult(it, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==100&&resultCode==RESULT_OK&&data!=null)
        {
            Bundle bundle=data.getExtras();
            if(bundle!=null)
            {
                String mesaj=bundle.getString("Mesaj","");
                int suma=bundle.getInt("Suma",0);
                Toast.makeText(this,"Mesaj: "+mesaj+"\nSuma: "+suma,Toast.LENGTH_LONG).show();
            }
        }
    }
}