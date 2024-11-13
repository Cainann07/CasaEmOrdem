package com.example.casaemordem;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class TesteMaluActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_teste_malu);

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