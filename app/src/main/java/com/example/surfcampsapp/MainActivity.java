package com.example.surfcampsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button login;
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view) {
        Intent intent = new Intent(this, Ofertas.class);
        startActivity(intent);
    }

    public void registar(View view) {
        Intent intent = new Intent(this, userRegister.class);
        startActivity(intent);
    }
}