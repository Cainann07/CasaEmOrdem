package com.example.casaemordem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MeusServicosHistoricoProfissionalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_meus_servicos_historico_profissional);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void redirectMeusServicosPendentesProfissional(View view){
        Intent proxPag = new Intent(this, MeusServicosPendentesProfissionalActivity.class);
        startActivity(proxPag);
    }

    public void redirectMeusServicosAgendadosProfissional(View view){
        Intent proxPag = new Intent(this, MeusServicosAgendadosProfissionalActivity.class);
        startActivity(proxPag);
    }

    public void redirectDetalhesServicoProfissional(View view){
        Intent proxPag = new Intent(this, DetalhesServicoProfissionalActivity.class);
        startActivity(proxPag);
    }
}