package com.example.surfcampsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Ajuda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajuda);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.ajuda);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ofertas:
                        startActivity(new Intent(getApplicationContext(), Ofertas.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.reservas:
                        startActivity(new Intent(getApplicationContext(), Reservas.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.ajuda:
                        return true;
                    case R.id.perfil:
                        startActivity(new Intent(getApplicationContext(), Perfil.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}