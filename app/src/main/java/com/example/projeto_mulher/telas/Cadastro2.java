package com.example.projeto_mulher.telas;

import static com.example.projeto_mulher.servicos.util.Util.txToString;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.projeto_mulher.R;
import com.example.projeto_mulher.regras.dominio.MedidaProtetiva;
import com.example.projeto_mulher.regras.dominio.Vitima;

public class Cadastro2 extends AppCompatActivity {

    private EditText txNome;
    private EditText txCpf;
    private EditText txTelefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro2);
        Bundle dados = getIntent().getExtras();
        MedidaProtetiva medidaProtetiva = (MedidaProtetiva) dados.getSerializable("medida");
        Vitima vitima = new Vitima();
        if (medidaProtetiva != null) vitima.setMedidaProtetiva(medidaProtetiva);
        txNome = findViewById(R.id.txNome);
        txCpf = findViewById(R.id.txCpf);
        txTelefone = findViewById(R.id.txTelefone);
        vitima.setNome(txToString(txNome));
        vitima.setCpf(txToString(txCpf));
    }
}