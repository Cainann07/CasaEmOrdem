package com.example.casaemordem;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PaginaInicialClienteActivity extends AppCompatActivity {

    private BottomNavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_inicial_cliente);

        navigationView = (BottomNavigationView) findViewById(R.id.navigationView);

    }
}