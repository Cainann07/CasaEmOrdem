package com.example.casaemordem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ContatarServicoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_contatar_servico);
    }

    public void SelecionarProf(View view){
        startActivity(new Intent(this, ProfissionaisListViewActivity.class));
    }

    public void funcionalidadeEscolhida(View view){
        Toast.makeText(this, "Estilo de Uso Selecionado", Toast.LENGTH_SHORT).show();
    }
}