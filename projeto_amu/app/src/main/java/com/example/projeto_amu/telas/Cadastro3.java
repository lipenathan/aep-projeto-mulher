package com.example.projeto_amu.telas;

import static com.example.projeto_amu.servicos.util.Logs.CADASTRO_3;
import static com.example.projeto_amu.servicos.util.Logs.logErro;
import static com.example.projeto_amu.servicos.util.Util.txToLong;
import static com.example.projeto_amu.servicos.util.Util.txToString;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projeto_amu.R;
import com.example.projeto_amu.regras.dominio.Endereco;
import com.example.projeto_amu.regras.dominio.Vitima;
import com.example.projeto_amu.servicos.repositorio.RepositorioEndereco;
import com.example.projeto_amu.servicos.repositorio.RepositorioVitima;

/**
 * Cadastro -> dados de endereço
 * @author Felipe Nathan
 * @version 1.0 15/11/2021
 * @since 15/11/2021
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
        Vitima vitima = new Vitima();
        try {
            endereco.setEstado(txToString(txEstado));
            endereco.setCidade(txToString(txCidade));
            endereco.setRua(txToString(txRua));
            endereco.setNumero(txToLong(txNumero));
            vitima.setNome(nome);
            vitima.setCpf(cpf);
            vitima.setEmail(email);
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