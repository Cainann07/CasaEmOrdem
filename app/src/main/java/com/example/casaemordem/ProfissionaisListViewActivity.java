package com.example.casaemordem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.casaemordem.databinding.ActivityProfissionaisListViewBinding;

import java.util.ArrayList;

public class ProfissionaisListViewActivity extends AppCompatActivity {

    ActivityProfissionaisListViewBinding binding;
    ListAdapter listAdapter;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListData listData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfissionaisListViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        int[] imageList = { R.drawable.imgeletricista,R.drawable.imgdomestica, R.drawable.imgencanador, R.drawable.imgpedreiro, R.drawable.imgmarceneiro, R.drawable.imgoperamaquinas, R.drawable.imgserralheiro};
        int[] ingredientList = {R.string.pedroAlvesPrudutos, R.string.mariaLuizaProdutos,R.string.matheusProdutos,R.string.ericGomesProdutos,R.string.warlisonProdutos, R.string.brunoVieiraProdutos, R.string.DavidProdutos};
        int[] descList = {R.string.pedroAlvesDesc, R.string.mariaLuizaDesc, R.string.matheusDesc,R.string.ericGomesDesc,R.string.warlisonDesc, R.string.brunoVieiraDesc, R.string.davidDesc};
        String[] nameList = {"Pedro Alves", "Maria Luiza", "Matheus Cainan", "Eric Gomes", "Warlison Junio","Bruno Vieira", "David lourenço"};
        String[] timeList = {"Mat. Class A", "Mat. Class A", "Mat. Class B","Mat. Class C", "Mat. Class B", "Mat. Class B", "Mat. Class C"};
        for (int i = 0; i < imageList.length; i++){
            listData = new ListData(nameList[i], timeList[i], ingredientList[i], descList[i], imageList[i]);
            dataArrayList.add(listData);
        }
        listAdapter = new ListAdapter(ProfissionaisListViewActivity.this, dataArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ProfissionaisListViewActivity.this, ProfissionalDetalhado.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("time", timeList[i]);
                intent.putExtra("ingredients", ingredientList[i]);
                intent.putExtra("desc", descList[i]);
                intent.putExtra("image", imageList[i]);
                startActivity(intent);
            }
        });
    }
}
