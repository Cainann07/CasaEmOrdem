package com.example.casaemordem;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.casaemordem.pojo.UsuarioProfissional;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    Intent proxPag = new Intent(this, PaginaInicialClienteActivity.class);

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    private EditText txtBuscaEmail;
    private EditText txtBuscaSenha;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       // super.onCreate(savedInstanceState);
       // EdgeToEdge.enable(this);
       // setContentView(R.layout.activity_login);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        iniciarFireBase();

        txtBuscaEmail = findViewById(R.id.idEntrarEmail);
        txtBuscaSenha = findViewById(R.id.idEntrarSenha);
    };

    private void iniciarFireBase(){
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("usuario");
    }

    public void buscarUsuario(View view) {
        String emailBusca = txtBuscaEmail.getText().toString();

        if (!emailBusca.isEmpty()) {
            databaseReference.orderByChild("email").equalTo(emailBusca).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            UsuarioProfissional usuario = snapshot.getValue(UsuarioProfissional.class);
                            startActivity(proxPag);
                            txtResultado.setText("Nome: " + usuario.getNome() + "\nEmail: " + usuario.getEmail());
                        }
                    } else {
                        txtResultado.setText("Usuário não encontrado.");
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Login.this, "Erro na busca: " + databaseError.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        } else {
            Toast.makeText(this, "Digite um nome para buscar", Toast.LENGTH_LONG).show();
        }

    }

}

