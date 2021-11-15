package com.example.projeto_mulher.telas;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projeto_mulher.R;
import com.example.projeto_mulher.servicos.repositorio.RepositorioVitima;

public class Cadastro extends AppCompatActivity {

    EditText txNome;
    EditText txCpf;
    // repositorio de persistência do domínio vítima
    RepositorioVitima repositorioVitima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro1);
        txNome = findViewById(R.id.txNome);
        txCpf = findViewById(R.id.txCpf);
        repositorioVitima = new RepositorioVitima(this);
    }

    public void cadastrarVitima(View view) {
    }
}