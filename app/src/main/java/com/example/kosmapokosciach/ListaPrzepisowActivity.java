package com.example.kosmapokosciach;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListaPrzepisowActivity extends AppCompatActivity {
    private ArrayList<Przepis> przepisArrayList;
    private ListView listViewprzepisy;
    private ArrayAdapter<Przepis> arrayAdapter;
    private ListView listViewListaPrzepisow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_przepisow2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        przepisArrayList = RepozytoriumPrzepisow.zwrocPrzepisy();
        listViewprzepisy = findViewById(R.id.listaViewCiastka);
        arrayAdapter = new ArrayAdapter<>(
                ListaPrzepisowActivity.this,
                android.R.layout.simple_list_item_1,
                przepisArrayList
        );
        listViewprzepisy.setAdapter(arrayAdapter);
    }
}