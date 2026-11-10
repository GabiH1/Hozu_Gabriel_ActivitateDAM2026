package com.example.maimultaexersare;

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

public class AddTableta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_tableta);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Spinner spinner=findViewById(R.id.Hozu_GabrielSpiner);
        String model[]={"Huawei","Samsung","Apple","Xiaomi"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,model);
        spinner.setAdapter(adapter);

    }

    public void ReturneazaTableta(View view) {
        EditText idTableta=findViewById(R.id.Hozu_GabrielidTableta);
        Spinner model=findViewById(R.id.Hozu_GabrielSpiner);
        EditText spatiuMemorie=findViewById(R.id.Hozu_GabrielSpatiuMemorie);
        CheckBox esteOled=findViewById(R.id.Hozu_GabrielCheckBox);

        int id=Integer.parseInt(idTableta.getText().toString());
        String model1=model.getSelectedItem().toString();
        int spatiu=Integer.parseInt(spatiuMemorie.getText().toString());
        boolean este=esteOled.isChecked();

        Tableta tableta=new Tableta(id,model1,spatiu,este);
        Intent intent=new Intent();
        Bundle bundle=new Bundle();
        bundle.putParcelable("tableta",tableta);
        intent.putExtras(bundle);
        setResult(RESULT_OK,intent);
        finish();

    }
}