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
import com.example.projeto_mulher.servicos.repositorio.RepositorioCredencial;
import com.example.projeto_mulher.servicos.repositorio.RepositorioTelefone;
import com.example.projeto_mulher.telas.dialogos.Dialog;

/**
 * step 4 -> celular e pin
 */
public class Cadastro4 extends AppCompatActivity {

    // repositórios
    private RepositorioTelefone repositorioTelefone;
    private RepositorioCredencial repositorioCredencial;

    private Long idVitima;
    private EditText txCelular;
    private EditText txPin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro4);
        repositorioTelefone = new RepositorioTelefone(this);
        repositorioCredencial = new RepositorioCredencial(this);
        Bundle dados = getIntent().getExtras();
        idVitima = dados.getLong("idVitima");
        txCelular = findViewById(R.id.txCelular);
        txPin = findViewById(R.id.txPin);
    }

    public void irParaTela5(View view) {
        Telefone telefone = new Telefone(txToString(txCelular));
        String novoPin;
        telefone.setIdPessoa(idVitima);
        telefone.setTipoPessoa(VITIMA);
        try {
            telefone.validarCampos();
            repositorioTelefone.inserirTelefone(telefone);
            novoPin = txToString(txPin);
            if (novoPin.length() < 4) throw new Exception("pin precisa conter\nno mínimo 4 digitos");
            repositorioCredencial.atualizar(novoPin);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            logErro(CADASTRO_4, e);
            return;
        }
        mensagemTeste();
        Intent intent = new Intent(this, Cadastro5.class);
        startActivity(intent);
    }

    public void mensagemTeste() {
        Dialog dialog = new Dialog("IMPORTANTE!", "Olá, o AMU possui uma calculadora que sobrepõe " +
                "a aplicação principal\n\nApós concluir seu cadastro, sempre que precisar acessar o aplicativo " +
                "digite o PIN que você escolheu e então o sinal de igual(=) para acessar");
        dialog.show(getSupportFragmentManager(), "dialogo");
    }
}