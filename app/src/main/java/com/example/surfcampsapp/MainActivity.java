package com.example.surfcampsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText email, password;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.loginEmail);
        password = (EditText) findViewById(R.id.loginPassword);

    }

    public void login(View view) {
        ArrayList<String> registos = readRegistos();


        for (int i = 0; i < registos.size(); i++) {
            if(registos.get(i).equals(email.getText().toString()) && registos.get(i+1).equals(password.getText().toString())){
                Intent intent = new Intent(this, Ofertas.class);
                intent.putExtra("emailLogged", email.getText().toString());
                startActivity(intent);
                return;
            }
        }
        Toast.makeText(this, "Email ou Password Invalidos", Toast.LENGTH_LONG).show();
    }

    public void registar(View view) {
        Intent intent = new Intent(this, userRegister.class);
        startActivity(intent);
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