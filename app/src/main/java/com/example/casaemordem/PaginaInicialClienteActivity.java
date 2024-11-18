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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pagina_inicial_cliente);
        Slider();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.btnMenuHome) {
                startActivity(new Intent(this, PaginaInicialClienteActivity.class));
            } else if (item.getItemId() == R.id.btnMenuChat) {
                startActivity(new Intent(this, InfoEnderecoClienteActivity.class));
            }else if (item.getItemId() == R.id.fab_bottom) {
                startActivity(new Intent(this, ContrataServicoActivity.class));
            }else if (item.getItemId() == R.id.btnMenuCalendario) {
                startActivity(new Intent(this, InfoEnderecoClienteActivity.class));
            }else if (item.getItemId() == R.id.btnMenuUsuario) {
                startActivity(new Intent(this, InfoEnderecoClienteActivity.class));
            }
            return true;
        });
    }


    public void chat(View view) {
        startActivity(new Intent(this, InfoEnderecoClienteActivity.class));
    }

    public void ContratarServico(View view) {
        startActivity(new Intent(this, ContrataServicoActivity.class));
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