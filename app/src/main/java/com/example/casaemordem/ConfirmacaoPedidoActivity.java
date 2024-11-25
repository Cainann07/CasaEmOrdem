package com.example.casaemordem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.casaemordem.pojo.QdtComodosCliente;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Locale;

public class ConfirmacaoPedidoActivity extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacao_pedido);

        iniciarFireBase();
        RecuperaQdtServico();
    }

    public void PaginaInicial(View view) {
        startActivity(new Intent(this, PaginaInicialClienteActivity.class));
    }

    private void iniciarFireBase() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("comodosCliente");
    }

    public void RecuperaQdtServico() {
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot1) {
                if (dataSnapshot1.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot1.getChildren()) {
                        QdtComodosCliente qdtComodosCliente = snapshot.getValue(QdtComodosCliente.class);

                        if (qdtComodosCliente != null) {
                            String quartos = qdtComodosCliente.getQuantidadeComodosCliente();

                            if (quartos != null && !quartos.isEmpty()) {
                                calcValorServico(quartos);
                            } else {
                                Toast.makeText(ConfirmacaoPedidoActivity.this, "Dados incompletos para calcular o valor do serviço.", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(ConfirmacaoPedidoActivity.this, "Erro ao processar os dados.", Toast.LENGTH_LONG).show();
                        }
                    }
                } else {
                    Toast.makeText(ConfirmacaoPedidoActivity.this, "Impossível realizar a contagem. Nenhum dado encontrado.", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(ConfirmacaoPedidoActivity.this, "Erro na busca: " + databaseError.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void calcValorServico(String qdtComodosCliente) {
        double valorClasseA = 100.0;
        double valorClasseB = 80.0;
        double valorClasseC = 60.0;
        double valorServico;

        try {
            double quartosTrans = Double.parseDouble(qdtComodosCliente);
            valorServico = quartosTrans * valorClasseA;

            TextView textView = findViewById(R.id.textExibirValorServico);
            textView.setText(String.format(Locale.getDefault(), "%.2f", valorServico));
        } catch (NumberFormatException e) {
            Toast.makeText(ConfirmacaoPedidoActivity.this, "Erro ao converter a quantidade de cômodos.", Toast.LENGTH_LONG).show();
        }
    }
}
