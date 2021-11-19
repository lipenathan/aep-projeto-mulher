package com.example.projeto_mulher.telas;

import static com.example.projeto_mulher.servicos.util.Logs.CADASTRO_3;
import static com.example.projeto_mulher.servicos.util.Logs.logErro;
import static com.example.projeto_mulher.servicos.util.Util.txToLong;
import static com.example.projeto_mulher.servicos.util.Util.txToString;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projeto_mulher.R;
import com.example.projeto_mulher.regras.dominio.Endereco;
import com.example.projeto_mulher.regras.dominio.Vitima;
import com.example.projeto_mulher.servicos.repositorio.RepositorioEndereco;
import com.example.projeto_mulher.servicos.repositorio.RepositorioVitima;

/**
 * step 3 -> dados de endereço
 */
public class Cadastro3 extends AppCompatActivity {

    // repositórios
    private RepositorioEndereco repositorioEndereco;
    private RepositorioVitima repositorioVitima;

    private String nome;
    private String cpf;
    private String email;
    private EditText txEstado;
    private EditText txCidade;
    private EditText txRua;
    private EditText txNumero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro3);
        repositorioEndereco = new RepositorioEndereco(this);
        repositorioVitima = new RepositorioVitima(this);
        Bundle dados = getIntent().getExtras();
        nome = dados.getString("nome");
        cpf = dados.getString("cpf");
        email = dados.getString("email");
        txEstado = findViewById(R.id.txCelular);
        txCidade = findViewById(R.id.txCidade);
        txRua = findViewById(R.id.txRua);
        txNumero = findViewById(R.id.txNumero);
    }

    public void irParaTela4(View view) {
        Endereco endereco = new Endereco();
        endereco.setEstado(txToString(txEstado));
        endereco.setCidade(txToString(txCidade));
        endereco.setRua(txToString(txRua));
        endereco.setNumero(txToLong(txNumero));
        Vitima vitima = new Vitima();
        vitima.setNome(nome);
        vitima.setCpf(cpf);
        vitima.setEmail(email);
        try {
            endereco.validarCadastro3();
            //salva endereço na base e recebe id
            endereco.setId(repositorioEndereco.inserirEndereco(endereco));
            vitima.setEndereco(endereco);
            //salva vitima na base e recebe id
            vitima.setId(repositorioVitima.inserirVitimaSemMedida(vitima));
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            logErro(CADASTRO_3, e);
            return;
        }
        Intent intent = new Intent(this, Cadastro4.class);
        intent.putExtra("idVitima", vitima.getId());
        startActivity(intent);
    }
}