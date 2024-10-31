package com.example.casaemordem;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.casaemordem.pojo.UsuarioProfissional;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SelecaoProfissionalActivity extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_selecao_profissional);

        iniciarFireBase();

        buscarUsuario();

    }

    private void iniciarFireBase() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("usuario");
    }

    public void buscarUsuario() {

        List<String> usuarios = new ArrayList<>();

        databaseReference.orderByChild("nome").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        UsuarioProfissional usuario = snapshot.getValue(UsuarioProfissional.class);

                        String dadosProfissional =
                                "Nome: " + usuario.getNome() +
                                ", Email: " + usuario.getEmail() +
                                ", Senha: " + usuario.getSenha();
                        if (usuario != null) {
                            usuarios.add(dadosProfissional);
                        }
                    }
                    mostraDados(usuarios);
                } else {
                    Toast.makeText(SelecaoProfissionalActivity.this, "\"Dados não encontrados.\"", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(SelecaoProfissionalActivity.this, "Erro na busca: " + databaseError.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    public void mostraDados(List usuarios) {

        ListView listView = findViewById(R.id.idListaProfissinais);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, usuarios);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(SelecaoProfissionalActivity.this, "Você selecionou " + item, Toast.LENGTH_LONG).show();

            }
        });
    }
}