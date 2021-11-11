package com.example.projeto_mulher.telas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.projeto_mulher.R;
import com.example.projeto_mulher.regras.dominio.Telefone;
import com.example.projeto_mulher.regras.dominio.Vitima;


public class Login extends AppCompatActivity {

    private Button btCadastro;
    private TextView txNome;
    private TextView txTelefone;
    private TextView txOcorrencia;
    private TextView txResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        btCadastro = findViewById(R.id.btCadastro);
        txNome = findViewById(R.id.txNome);
        txTelefone = findViewById(R.id.txTelefone);
        txOcorrencia = findViewById(R.id.txOcorrencia);
        txResultado = findViewById(R.id.txResultado);
    }

    public void cadastrar(View view) {
        Vitima vitima = new Vitima();
        vitima.setNome(txNome.getText().toString());
        Telefone telefone = new Telefone();
        telefone.setNumero(txTelefone.getText().toString());
        try {
            vitima.adicionarTelefone(telefone);
        } catch (Exception e) {
            txResultado.setText(e.getMessage());
        }
        vitima.setNumeroOcorrencia(txOcorrencia.getText().toString());
        txResultado.setText(vitima.toString());
    }
}