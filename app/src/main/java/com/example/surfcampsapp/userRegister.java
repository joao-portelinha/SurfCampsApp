package com.example.surfcampsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class userRegister extends AppCompatActivity {
    Button registar;
    EditText registoEmail, registoPassword, registoConfirmarPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        registar = findViewById(R.id.userRegister_registar);
        registoEmail = findViewById(R.id.registoEmail);
        registoPassword = findViewById(R.id.registoPassword);
        registoConfirmarPassword = findViewById(R.id.registoConfirmarPassword);

        // Spinners
        Spinner spinner_generos = (Spinner) findViewById(R.id.spinner_genero);
        ArrayAdapter<CharSequence> adapter_generos = ArrayAdapter.createFromResource(this, R.array.generos, R.layout.spinner_item);
        adapter_generos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_generos.setAdapter(adapter_generos);

        Spinner spinner_nacionalidade = (Spinner) findViewById(R.id.spinner_nacionalidade);
        ArrayAdapter<CharSequence> adapter_nacionalidade = ArrayAdapter.createFromResource(this, R.array.nacionaliade, R.layout.spinner_item);
        adapter_nacionalidade.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_nacionalidade.setAdapter(adapter_nacionalidade);

        registar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkData();
            }
        });
    }

    void checkData() {
        if (isEmail(registoEmail) == false) {
            registoEmail.setError("Insira um email valido");
            Toast.makeText(this, "Inserir email valido", Toast.LENGTH_LONG).show();
        }

        if (isEmpty(registoPassword) || registoPassword.length() < 8) {
            registoPassword.setError("Password tem de conter mais que 8 carateres");
            Toast.makeText(this, "Inserir password valida", Toast.LENGTH_LONG).show();
        }

        if(!registoConfirmarPassword.getText().toString().equals(registoPassword.getText().toString())) {
            registoConfirmarPassword.setError("Password's diferentes");
            Toast.makeText(this, "Inserir password valida", Toast.LENGTH_LONG).show();
        }
    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence pw = text.getText().toString();
        return TextUtils.isEmpty(pw);
    }
}