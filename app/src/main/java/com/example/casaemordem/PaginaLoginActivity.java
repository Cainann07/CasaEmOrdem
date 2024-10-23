package com.example.casaemordem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.casaemordem.pojo.UsuarioProfissional;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PaginaLoginActivity extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    private EditText txtBuscaEmail;
    private EditText txtBuscaSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_login);

        iniciarFireBase();

        txtBuscaEmail = findViewById(R.id.idEntrarEmail);
        txtBuscaSenha = findViewById(R.id.idEntrarSenha);
    }

    private void iniciarFireBase(){
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("usuario");
    }

    public void buscarUsuario(View view) {
        String emailBusca = txtBuscaEmail.getText().toString();
        String senhaBusca = txtBuscaSenha.getText().toString();
        String chaveEmail;
        String chaveSenha;

        if (!emailBusca.isEmpty() && !senhaBusca.isEmpty() ) {
            databaseReference.orderByChild("email").equalTo(emailBusca).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            UsuarioProfissional usuario = snapshot.getValue(UsuarioProfissional.class);
                            if (!usuario.getSenha().equals(senhaBusca)){
                                Toast.makeText(PaginaLoginActivity.this, "\"Senha inválida.\"" , Toast.LENGTH_LONG).show();
                                break;
                            } else {
                                Intent proxPag = new Intent(PaginaLoginActivity.this, PaginaInicialClienteActivity.class);
                                startActivity(proxPag);
                            }

                        }
                    } else {
                        Toast.makeText(PaginaLoginActivity.this, "\"Usuário não encontrado.\"" , Toast.LENGTH_LONG).show();

                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(PaginaLoginActivity.this, "Erro na busca: " + databaseError.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        } else {
            Toast.makeText(this, "Digite seu email e senha para entrar", Toast.LENGTH_LONG).show();
        }

    }


}