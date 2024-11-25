package com.example.casaemordem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MeusServicosPendentesProfissionalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_meus_servicos_pendentes_profissional);

    }

    public void detalhesServico(View view){
        startActivity(new Intent(this, DetalhesServicoProfissionalActivity.class));
    }

    public void redirectServicosAgendadosProfissional(View view){
        Intent proxPag = new Intent(this, MeusServicosAgendadosProfissionalActivity.class);
        startActivity(proxPag);
    }

    public void redirectHistoricoProfissional(View view){
        Intent proxPag = new Intent(this, MeusServicosHistoricoProfissionalActivity.class);
        startActivity(proxPag);
    }
}