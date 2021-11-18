package com.example.projeto_mulher.telas;

import static com.example.projeto_mulher.regras.dominio.TipoPessoa.VITIMA;
import static com.example.projeto_mulher.servicos.util.Logs.CADASTRO_4;
import static com.example.projeto_mulher.servicos.util.Logs.logErro;
import static com.example.projeto_mulher.servicos.util.Util.txToString;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projeto_mulher.R;
import com.example.projeto_mulher.regras.dominio.Telefone;
import com.example.projeto_mulher.servicos.repositorio.RepositorioTelefone;

public class Cadastro4 extends AppCompatActivity {

    // repositórios
    private RepositorioTelefone repositorioTelefone;

    private Long idVitima;
    private EditText txCelular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro4);
        repositorioTelefone = new RepositorioTelefone(this);
        Bundle dados = getIntent().getExtras();
        idVitima = dados.getLong("idVitima");
        txCelular = findViewById(R.id.txCelular);
    }

    public void irParaTela5(View view) {
        Telefone telefone = new Telefone(txToString(txCelular));
        telefone.setIdPessoa(idVitima);
        telefone.setTipoPessoa(VITIMA);
        try {
            telefone.validarCampos();
            repositorioTelefone.inserirTelefone(telefone);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            logErro(CADASTRO_4, e);
            return;
        }
        Intent intent = new Intent(this, Cadastro5.class);
        startActivity(intent);
    }
}