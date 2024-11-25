package com.example.casaemordem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class toolbarProfissional extends AppCompatActivity {

          public void RetornarPaginaInicialProfissional(View view) {
            Intent mandaDados4 = new Intent(this, PaginaInicialProfissionalActivity.class);
            startActivity(mandaDados4);
        }

}