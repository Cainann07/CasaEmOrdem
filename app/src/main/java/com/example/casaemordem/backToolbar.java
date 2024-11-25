package com.example.casaemordem;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class backToolbar  extends AppCompatActivity {

    public void RetornarPaginaInicial(View view) {
        Intent mandaDados3 = new Intent(this, PaginaInicialClienteActivity.class);
        startActivity(mandaDados3);

    }
}
