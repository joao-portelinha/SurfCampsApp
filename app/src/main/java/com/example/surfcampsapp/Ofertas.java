package com.example.surfcampsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Ofertas extends AppCompatActivity {

    RecyclerView recyclerView;

    String[] titulos, escolas, desc, preco, extras;

    int[] images = {R.drawable.aula1, R.drawable.kalux, R.drawable.aula2, R.drawable.aula4};

    String emailLogged;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ofertas);

        recyclerView = findViewById(R.id.aulas_recyclerView);

        titulos = getResources().getStringArray(R.array.titulos_aulas);
        escolas = getResources().getStringArray(R.array.escolas_aulas);
        desc = getResources().getStringArray(R.array.desc_aulas);
        preco = getResources().getStringArray(R.array.preco_aulas);
        extras = getResources().getStringArray(R.array.extras_aulas);

        emailLogged = getIntent().getStringExtra("emailLogged");

        MyAdapter myAdapter = new MyAdapter(this, titulos, escolas, desc, preco, extras, images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.ofertas);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.reservas:
                        startActivity(new Intent(getApplicationContext(), Reservas.class).putExtra("emailLogged", emailLogged).putExtra("nome", "nothing"));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.ajuda:
                        startActivity(new Intent(getApplicationContext(), Ajuda.class).putExtra("emailLogged", emailLogged));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.perfil:
                        startActivity(new Intent(getApplicationContext(), Perfil.class).putExtra("emailLogged", emailLogged));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}