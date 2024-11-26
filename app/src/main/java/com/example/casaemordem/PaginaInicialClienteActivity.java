package com.example.casaemordem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.casaemordem.databinding.ActivityPaginaInicialClienteBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;


public class PaginaInicialClienteActivity extends AppCompatActivity {
    ActivityPaginaInicialClienteBinding binding;

        String IDuserLogado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pagina_inicial_cliente);
        Slider();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        Intent recebeDados = getIntent();
        Bundle bundle = recebeDados.getExtras();

        IDuserLogado = bundle.getString("IDuserLogado");
        bottomNavigationView.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.btnMenuHome) {
                startActivity(new Intent(this, PaginaInicialClienteActivity.class));
            } else if (item.getItemId() == R.id.btnMenuChat) {
                startActivity(new Intent(this, ChatClienteActivity.class));
            } else if (item.getItemId() == R.id.fab_bottom) {
                startActivity(new Intent(this, ContatarServicoActivity.class));
            } else if (item.getItemId() == R.id.btnMenuCalendarioProfissional) {
                startActivity(new Intent(this, CalendarioActivity.class));
            } else if (item.getItemId() == R.id.btnMenuUsuario) {
                startActivity(new Intent(this, InfoEnderecoClienteActivity.class));
            }
            return true;
        });
    }


    public void chat(View view) {
        startActivity(new Intent(this, InfoEnderecoClienteActivity.class));
    }

    public void ContratarServico(View view) {
        Intent mandaDados2 = new Intent(this, ContatarServicoDeLimpezaActivity.class);
        Bundle bundleEnvia = new Bundle();
        bundleEnvia.putString("IDuserLogado", IDuserLogado);
        mandaDados2.putExtras(bundleEnvia);
        startActivity(mandaDados2);
    }

    public void Slider() {
        ImageSlider imageSlider = findViewById(R.id.imageSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.imgpromocaolimpeza, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.imgpromocaoeletrica, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.imgpromocaohidraulica, ScaleTypes.FIT));

        imageSlider.setImageList(slideModels, ScaleTypes.FIT);
    }
}