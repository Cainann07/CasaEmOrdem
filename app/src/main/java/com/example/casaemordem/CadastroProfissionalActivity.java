package com.example.casaemordem;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.casaemordem.pojo.UsuarioProfissional;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class CadastroProfissionalActivity extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase;

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastro_profissional);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        IniciarFireBase();
    }

    protected void IniciarFireBase() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public void cadastrar(View view) {
        EditText txtNome = findViewById(R.id.idCadastroNome);
        EditText txtEmail = findViewById(R.id.idCadastroEmail);
        EditText txtSenha = findViewById(R.id.idCadastroSenha);
        EditText txtConfirmaSenha = findViewById(R.id.idConfirmaSenha);
        EditText txtProfissao = findViewById(R.id.idCadastroProfissao);
//         while (txtSenha != txtConfirmaSenha) {
//                 Toast.makeText(this, "Senha não é compatível com a confirmação", Toast.LENGTH_SHORT).show();
//             };
        UsuarioProfissional usuario_prof = new UsuarioProfissional(
                UUID.randomUUID().toString(), txtNome.getText().toString(), txtEmail.getText().toString()
                , txtSenha.getText().toString(), txtProfissao.getText().toString());

        databaseReference.child("usuario").child(usuario_prof.getUUID()).setValue(usuario_prof);

        txtNome.setText(null);
        txtEmail.setText(null);
        txtSenha.setText(null);
        txtConfirmaSenha.setText(null);
        txtProfissao.setText(null);
        Toast.makeText(this, "Dados salvos com sucesso", Toast.LENGTH_SHORT).show();
    }

}