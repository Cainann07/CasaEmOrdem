package com.example.casaemordem;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MeusServicosAgendadosClienteActivity extends AppCompatActivity {

    private TextView tabAgendados;
    private TextView tabPendentes;
    private TextView tabHistorico;
    private List<TextView> tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_meus_servicos_agendados_cliente);

        // Inicializa as abas
        tabAgendados = findViewById(R.id.btnAgendados);
        tabPendentes = findViewById(R.id.btnPendentes);
        tabHistorico = findViewById(R.id.btnHistorico);

        // Adiciona as abas a uma lista para facilitar o manuseio
        tabs = new ArrayList<>();
        tabs.add(tabAgendados);
        tabs.add(tabPendentes);
        tabs.add(tabHistorico);

        // Configura os listeners de clique para alternar entre as abas
        tabAgendados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTabSelected(tabAgendados);
            }
        });

        tabPendentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTabSelected(tabPendentes);
            }
        });

        tabHistorico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTabSelected(tabHistorico);
            }
        });

        // Define "Agendados" como a aba selecionada inicialmente
        setTabSelected(tabAgendados);
    }

    private void setTabSelected(TextView selectedTab) {
        // Itera sobre as abas e define o estilo de negrito apenas para a aba selecionada
        for (TextView tab : tabs) {
            if (tab == selectedTab) {
                tab.setTypeface(null, Typeface.BOLD); // Aba selecionada em negrito
            } else {
                tab.setTypeface(null, Typeface.NORMAL); // Outras abas em estilo normal
            }
        }
    }
}