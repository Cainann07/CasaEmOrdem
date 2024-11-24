package com.example.casaemordem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.casaemordem.pojo.EnderecoCliente;
import com.example.casaemordem.pojo.UsuarioProfissional;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class ContatarServicoDeLimpezaActivity extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase;

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_contatar_servico_de_limpeza);

        IniciarFireBase();
    }

    protected void IniciarFireBase() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public void coletarEndereco(View view) {

        EditText txtLocalEndereco = findViewById(R.id.editLocalEndereco);
        EditText txtNumeroEndereco = findViewById(R.id.editTextNumeroEndereco);
        EditText txtComplemento = findViewById(R.id.editTextComplemento);
        EditText txtReferencia = findViewById(R.id.editTextReferencia);

        try {
            EnderecoCliente enderecoCliente = new EnderecoCliente(
                    UUID.randomUUID().toString(),txtLocalEndereco.getText().toString(),txtNumeroEndereco.getText().toString(), txtComplemento.getText().toString()
                    , txtReferencia.getText().toString());

            databaseReference.child("Endereco").child(enderecoCliente.getUUID()).setValue(enderecoCliente);

            txtLocalEndereco.setText(null);
            txtNumeroEndereco.setText(null);
            txtComplemento.setText(null);
            txtReferencia.setText(null);
            Toast.makeText(this, "Dados salvos com sucesso", Toast.LENGTH_SHORT).show();
            Intent proxPag = new Intent(this, ProfissionaisListViewActivity.class);
            startActivity(proxPag);
        } catch (Exception ex){
            Toast.makeText(this, "Infelizmente Ocorreu um erro tente novamente.\nErro" + ex , Toast.LENGTH_SHORT).show();
        }

    }
}