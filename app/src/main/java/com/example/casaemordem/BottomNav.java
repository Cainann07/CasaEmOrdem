package com.example.casaemordem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.casaemordem.databinding.ActivityBottomNavBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;


public class BottomNav extends AppCompatActivity {
    ActivityBottomNavBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bottom_nav);
        Slider();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

//        bottomNavigationView.setOnItemSelectedListener(item -> {
//            switch (item.getItemId()) {
//                case R.id.btnMenuHome:
//                    startActivity(new Intent(this, InfoEnderecoClienteActivity.class));
//                    return true;
//
//                case R.id.btnMenuHome:
//                    startActivity(new Intent(this, InfoEnderecoClienteActivity.class));
//                    return true;
//
//                case R.id.btnMenuHome:
//                    startActivity(new Intent(this, InfoEnderecoClienteActivity.class));
//                    return true;
//
//                default:
//                    return false;
//            }
//        });

        ///////////////////////////////////////////////////////////////////////

//        binding = ActivityBottomNavBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());

//        replaceFragment(new HomeFragment());
//        binding.bottomNavigationView.setBackground(null);
//        binding.bottomNavigationView. setOnItemSelectedListener(item -> {
//            switch (item.getItemId()) {
//                case R.id.btnMenuHome:
//                    replaceFragment(new HomeFragment());
//                    break;
//                case R.id.btnMenuChat:
//                    replaceFragment(new HomeFragment());
//                    break;
//                case R.id.btnMenuCalendario:
//                    replaceFragment(new HomeFragment());
//                    break;
//                case R.id.btnMenuUsuario:
//                    replaceFragment(new HomeFragment());
//                    break;
//            }
//            return true;
//        });



    }
//    private void replaceFragment(Fragment fragment) {
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.frame_layout, fragment);
//        fragmentTransaction.commit();
//    }

    public void chat(View view){
        startActivity(new Intent(this, InfoEnderecoClienteActivity.class));
    }

    public void ContratarServico(View view){
        startActivity(new Intent(this, ContrataServicoActivity.class));
    }

    public void Slider(){
        ImageSlider imageSlider = findViewById(R.id.imageSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.diarista2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.diarista, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.imgeletricista, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.imgdomestica, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.imgmarceneiro, ScaleTypes.FIT));

        imageSlider.setImageList(slideModels, ScaleTypes.FIT);
    }
}