package com.example.simularetest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Zbor> zboruri = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 && resultCode == RESULT_OK && data != null) {
            Bundle bundle = data.getExtras();
            if (bundle != null) {
                Zbor zbor = bundle.getParcelable("zbor");
                if (zbor != null)
                    zboruri.add(zbor);

                Toast.makeText(this, zbor.toString(), Toast.LENGTH_LONG).show();
            }

        }
    }

    public void AdaugaZbor(View view) {
        Intent it = new Intent(getApplicationContext(), AddZborActivity.class);
        startActivityForResult(it, 10);
    }

    public void VeziListaZboruri(View view) {
        Intent it = new Intent(getApplicationContext(), ListaZboruri.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("lista", (ArrayList<Zbor>) zboruri);
        it.putExtras(bundle);
        startActivityForResult(it, 20);
    }
}
