package com.example.surfcampsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Perfil extends AppCompatActivity {

    TextView email, primeiroNome, apelido;

    String emailLogged;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);


        email = findViewById(R.id.email_perfil2);
        primeiroNome = findViewById(R.id.nome_perfil2);
        apelido = findViewById(R.id.apelido_perfil2);

        emailLogged = getIntent().getStringExtra("emailLogged");

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.perfil);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ofertas:
                        startActivity(new Intent(getApplicationContext(), Ofertas.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.reservas:
                        startActivity(new Intent(getApplicationContext(), Reservas.class).putExtra("nome", "nothing"));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.ajuda:
                        startActivity(new Intent(getApplicationContext(), Ajuda.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.perfil:
                        return true;
                }
                return false;
            }
        });

        ArrayList<String> registos = readRegistos();
        email.setText(emailLogged);

        for (int i = 0; i < registos.size(); i++) {
            if(registos.get(i).equals(emailLogged)){
                primeiroNome.setText(registos.get(i+2));
                apelido.setText(registos.get(i+3));
            }
        }
    }

    ArrayList<String> readRegistos(){
        ArrayList<String> fileContent = new ArrayList<>();
        try {
            FileInputStream fileIn = openFileInput("registos.txt");
            InputStreamReader isr = new InputStreamReader(fileIn);
            BufferedReader buffReader = new BufferedReader(isr);

            String readString = buffReader.readLine();
            while (readString != null) {
                fileContent.add(readString);
                readString = buffReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }
}