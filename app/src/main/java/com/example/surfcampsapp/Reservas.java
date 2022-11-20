package com.example.surfcampsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Reservas extends AppCompatActivity {

    String emailLogged, nomeReserva;
    ImageView res1, res2, res3, res4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservas);

        emailLogged = getIntent().getStringExtra("emailLogged");

        nomeReserva = getIntent().getStringExtra("nome");

        res1 = findViewById(R.id.marcacao1);
        res2 = findViewById(R.id.marcacao2);
        res3 = findViewById(R.id.marcacao3);
        res4 = findViewById(R.id.marcacao4);

        switch (nomeReserva){
            case "Aula Principiante":
                res1.setVisibility(View.VISIBLE);
                break;
            case "Aula com Estadia":
                res2.setVisibility(View.VISIBLE);
                break;
            case "Aula com Gravação Incl.":
                res3.setVisibility(View.VISIBLE);
                break;
            case "Aula Teorica":
                res4.setVisibility(View.VISIBLE);
                break;
            default:
        }


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.reservas);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ofertas:
                        startActivity(new Intent(getApplicationContext(), Ofertas.class).putExtra("emailLogged", emailLogged));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.reservas:
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