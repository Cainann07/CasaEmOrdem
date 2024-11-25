package com.example.casaemordem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class PaginaInicialProfissionalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pagina_inicial_profissional);

        BottomNavigationView bottomNavigationViewProfissional = findViewById(R.id.bottomNavigationViewProfissional);

        SliderProfissional();

        bottomNavigationViewProfissional.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.btnMenuHomeProfissional) {
                startActivity(new Intent(this, PaginaInicialProfissionalActivity.class));
            } else if (item.getItemId() == R.id.btnMenuChatProfissional) {
                startActivity(new Intent(this, ChatProfissionalActivity.class));
            } else if (item.getItemId() == R.id.fab_bottom) {
                startActivity(new Intent(this, ContatarServicoActivity.class));
            } else if (item.getItemId() == R.id.btnMenuCalendarioProfissional) {
                startActivity(new Intent(this, CalendarioActivity.class));
            } else if (item.getItemId() == R.id.btnMenuUsuarioProfissional) {
                startActivity(new Intent(this, InfoEnderecoClienteActivity.class));
            }
            return true;
        });
    }

    public void SliderProfissional() {
        ImageSlider imageSliderProfissional = findViewById(R.id.imageSliderProfissional);
        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.imgpromocaolimpeza, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.imgpromocaoeletrica, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.imgpromocaohidraulica, ScaleTypes.FIT));

        imageSliderProfissional.setImageList(slideModels, ScaleTypes.FIT);
    }

    public void ServicoAgendado(View view) {
        startActivity(new Intent(this, MeusServicosPendentesProfissionalActivity.class));
    }
}