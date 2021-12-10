package com.example.projeto_mulher.telas;

import static com.example.projeto_mulher.servicos.util.Logs.CADASTRO_2;
import static com.example.projeto_mulher.servicos.util.Logs.logErro;
import static com.example.projeto_mulher.servicos.util.Util.txToString;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projeto_mulher.R;
import com.example.projeto_mulher.regras.dominio.MedidaProtetiva;
import com.example.projeto_mulher.regras.dominio.Vitima;
import com.example.projeto_mulher.servicos.util.Logs;
import com.github.rtoshiro.util.format.MaskFormatter;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

/**
 * Cadastro -> nome, cpf e e-amil
 * @author Felipe Nathan
 * @version 1.0 15/11/2021
 * @since 15/11/2021
 */
public class Cadastro2 extends AppCompatActivity {

    private EditText txNome;
    private EditText txCpf;
    private EditText txEmail;
    MedidaProtetiva medidaProtetiva;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro2);
        Bundle dados = getIntent().getExtras();
        medidaProtetiva = (MedidaProtetiva) dados.getSerializable("medida");
        txNome = findViewById(R.id.txNome);
        txCpf = findViewById(R.id.txCpf);
        txEmail = findViewById(R.id.txEmail);
        //mascara cpf
        SimpleMaskFormatter smf = new SimpleMaskFormatter("NNN.NNN.NNN-NN");
        MaskTextWatcher mtw = new MaskTextWatcher(txCpf, smf);
        txCpf.addTextChangedListener(mtw);
    }

    public void irParaTela3(View view) {
        Vitima vitima = new Vitima();
        vitima.setNome(txToString(txNome));
        vitima.setCpf(txToString(txCpf));
        vitima.setEmail(txToString(txEmail));
        try {
            vitima.validarCadasatro2();
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            logErro(CADASTRO_2,e);
            return;
        }
        Intent intent = new Intent(this, Cadastro3.class);
        intent.putExtra("medida", medidaProtetiva);
        intent.putExtra("nome", vitima.getNome());
        intent.putExtra("cpf", vitima.getCpf());
        intent.putExtra("email", vitima.getEmail());
        startActivity(intent);
    }
}