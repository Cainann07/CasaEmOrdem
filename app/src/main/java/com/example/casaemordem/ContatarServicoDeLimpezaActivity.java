package com.example.casaemordem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.casaemordem.pojo.EnderecoCliente;
import com.example.casaemordem.pojo.HorarioCliente;
import com.example.casaemordem.pojo.NumeroCliente;
import com.example.casaemordem.pojo.QdtComodosCliente;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class ContatarServicoDeLimpezaActivity extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase;

    private DatabaseReference databaseReference;

    PaginaLoginActivity obj = new PaginaLoginActivity();

    String IDuserLogado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_contatar_servico_de_limpeza);

        Intent recebeDados = getIntent();
        Bundle bundle  = recebeDados.getExtras();

        IDuserLogado = bundle.getString("IDuserLogado");

        IniciarFireBase();
    }

    protected void IniciarFireBase() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public void tipoSelecionado(View view) {
        Toast.makeText(this, "Tipo de Serviço escolhido com Sucesso", Toast.LENGTH_SHORT).show();
    }

    public void encontarProfissional(View view) {


        salvarEndereco();
        salvarHorarioCliente();
        salvarNumeroCliente();
        salvarQtdComodosCliente();

        Intent proxPag = new Intent(this, ProfissionaisListViewActivity.class);
        startActivity(proxPag);
    }

    public void salvarEndereco() {

        EditText txtLocalEndereco = findViewById(R.id.editLocalEndereco);
        EditText txtNumeroEndereco = findViewById(R.id.editTextNumeroEndereco);
        EditText txtComplemento = findViewById(R.id.editTextComplemento);
        EditText txtReferencia = findViewById(R.id.editTextReferencia);

        try {
            EnderecoCliente enderecoCliente = new EnderecoCliente(
                    UUID.randomUUID().toString(), txtLocalEndereco.getText().toString(), txtNumeroEndereco.getText().toString(), txtComplemento.getText().toString()
                    , txtReferencia.getText().toString());

            databaseReference.child("endereco").child(enderecoCliente.getUUID()).setValue(enderecoCliente);

            txtLocalEndereco.setText(null);
            txtNumeroEndereco.setText(null);
            txtComplemento.setText(null);
            txtReferencia.setText(null);
            Toast.makeText(this, "Endereço salvos com sucesso", Toast.LENGTH_SHORT).show();
        } catch (Exception ex) {
            Toast.makeText(this, "Infelizmente Ocorreu um erro ao salvar o Endereço do Cliente.\nErro" + ex, Toast.LENGTH_SHORT).show();
        }
    }

    public void salvarHorarioCliente() {

        EditText txtHorarioCliente = findViewById(R.id.idHorario);
        String txtUUIDcliente = IDuserLogado;

        try {
            HorarioCliente horarioCliente = new HorarioCliente(
                    txtUUIDcliente, txtHorarioCliente.getText().toString());

            databaseReference.child("horarioServico").child(horarioCliente.getUUID()).setValue(horarioCliente);

            Toast.makeText(this, "Horario salvo com sucesso", Toast.LENGTH_SHORT).show();
        } catch (Exception ex) {
            Toast.makeText(this, "Infelizmente Ocorreu um erro ao salvar o Horario do Cliente.\nErro" + ex, Toast.LENGTH_SHORT).show();
        }
    }

    public void salvarNumeroCliente() {

        EditText txtHorarioCliente = findViewById(R.id.idNumeroCliente);
        String txtUUIDcliente = IDuserLogado;

        try {
            NumeroCliente numeroCliente = new NumeroCliente(
                    txtUUIDcliente, txtHorarioCliente.getText().toString());

            databaseReference.child("numeroCliente").child(numeroCliente.getUUID()).setValue(numeroCliente);

            Toast.makeText(this, "Numero salvo com sucesso", Toast.LENGTH_SHORT).show();
        } catch (Exception ex) {
            Toast.makeText(this, "Infelizmente Ocorreu um erro ao salvar o numero do Cliente.\nErro" + ex, Toast.LENGTH_SHORT).show();
        }
    }

    public void salvarQtdComodosCliente() {

        EditText txtQtdComodosCliente = findViewById(R.id.editTextQtdComodos);
        String txtUUIDcliente = IDuserLogado;

        try {
            QdtComodosCliente qdtComodosCliente = new QdtComodosCliente(
                    txtUUIDcliente, txtQtdComodosCliente.getText().toString());

            databaseReference.child("comodosCliente").child(qdtComodosCliente.getUUID()).setValue(qdtComodosCliente);

            Toast.makeText(this, "Quantidade de Comodos salvos com sucesso", Toast.LENGTH_SHORT).show();
        } catch (Exception ex) {
            Toast.makeText(this, "Infelizmente Ocorreu um erro ao salvar a Quantidade de Comodos.\nErro" + ex, Toast.LENGTH_SHORT).show();
        }
    }
}