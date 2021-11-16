package com.example.projeto_mulher.telas;

import static com.example.projeto_mulher.servicos.util.Util.txToString;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projeto_mulher.R;
import com.example.projeto_mulher.regras.dominio.MedidaProtetiva;
import com.example.projeto_mulher.servicos.repositorio.RepositorioVitima;

public class Cadastro1 extends AppCompatActivity {

    EditText txNome;
    EditText txCpf;
    EditText txMedida;
    Button btProximo;
    // repositorio de persistência do domínio vítima
    RepositorioVitima repositorioVitima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro1);
        repositorioVitima = new RepositorioVitima(this);
        txMedida = findViewById(R.id.txMedida);
        btProximo = findViewById(R.id.btProximo);
        txMedida.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (txMedida.getText().toString().length() == 8) {
                    btProximo.setText("Próximo");
                } else if (txMedida.getText().toString().length() < 8){
                    btProximo.setText("Não possuo");
                }
                return false;
            }
        });
    }

    public void pularParaTela2(View view) {
        if (txToString(txMedida).length() > 0 && txToString(txMedida).length() < 8) {
            Toast.makeText(this, "Número de Medida Protetiva \n inválido", Toast.LENGTH_LONG).show();
            return;
        }
        boolean possuiMedida = txToString(txMedida).length() > 0;
        Intent intent = new Intent(getApplicationContext(), Cadastro2.class);
        MedidaProtetiva medidaProtetiva = new MedidaProtetiva(txToString(txMedida));
        intent.putExtra("medida", medidaProtetiva);
        startActivity(intent);
    }

    // utilitarios privados
}