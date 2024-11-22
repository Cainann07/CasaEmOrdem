package com.example.casaemordem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.casaemordem.databinding.ActivityProfissionalDetalhadoBinding;

public class ProfissionalDetalhado extends AppCompatActivity {
    ActivityProfissionalDetalhadoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfissionalDetalhadoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = this.getIntent();
        if (intent != null){
            String name = intent.getStringExtra("name");
            String time = intent.getStringExtra("time");
            int ingredients = intent.getIntExtra("ingredients", R.string.mariaLuizaProdutos);
            int desc = intent.getIntExtra("desc", R.string.mariaLuizaDesc);
            int image = intent.getIntExtra("image", R.drawable.imgeletricista);
            binding.detailName.setText(name);
            binding.detailTime.setText(time);
            binding.detailDesc.setText(desc);
            binding.detailIngredients.setText(ingredients);
            binding.detailImage.setImageResource(image);
        }
    }

    public void Voltar(View view){
        startActivity(new Intent(this, ProfissionaisListViewActivity.class));
    }

    public void Proseguir(View view){
        startActivity(new Intent(this, InfoEnderecoClienteActivity.class));
    }
}
