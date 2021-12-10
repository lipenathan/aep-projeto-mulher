package com.example.projeto_amu.telas;

import static com.example.projeto_amu.servicos.util.Util.txToString;

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

import com.example.projeto_amu.R;
import com.example.projeto_amu.regras.dominio.MedidaProtetiva;
import com.example.projeto_amu.servicos.repositorio.RepositorioVitima;
import com.example.projeto_amu.telas.dialogos.Dialogo;

/**
 * Cadastro -> Medida Protetiva
 *
 * @author Felipe Nathan
 * @version 1.0 15/11/2021
 * @since 15/11/2021
 */
public class Cadastro1 extends AppCompatActivity {

    // repositorio de persistência do domínio vítima
    RepositorioVitima repositorioVitima;
    private EditText txMedida;
    private Button btProximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro1);
        dialogoMedidaProtetiva();
        dialogoInternet();
        repositorioVitima = new RepositorioVitima(this);
        txMedida = findViewById(R.id.txMedida);
        btProximo = findViewById(R.id.btProximo);
        txMedida.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (txMedida.getText().toString().length() == 8) {
                    btProximo.setText("Próximo");
                } else if (txMedida.getText().toString().length() < 8) {
                    btProximo.setText("Não possuo");
                }
                return false;
            }
        });
    }

    public void irParaTela2(View view) {
        if (txToString(txMedida).length() > 0 && txToString(txMedida).length() < 8) {
            Toast.makeText(this, "Número de Medida Protetiva \n inválido", Toast.LENGTH_LONG).show();
            return;
        }
        boolean possuiMedida = txToString(txMedida).length() > 0;
        MedidaProtetiva medidaProtetiva;
        Intent intent = new Intent(this, Cadastro2.class);
        if (possuiMedida) {
            medidaProtetiva = new MedidaProtetiva(txToString(txMedida));
        } else {
            medidaProtetiva = null;
        }
        intent.putExtra("medida", medidaProtetiva);
        startActivity(intent);
    }

    //diálogos
    public void dialogoInternet() {
        Dialogo dialogo = new Dialogo("INFORMAÇÃO", "O aplicativo AMU não necessita de conexão com a internet." +
                "\nPor isso precisamos de alguns dados, para que o seu cadastro seja feito de forma completa.");
        dialogo.show(getSupportFragmentManager(), "dialogo");
    }

    public void dialogoMedidaProtetiva() {
        Dialogo dialogo = new Dialogo("INFORMAÇÃO", "Caso já possua uma medida protetiva digite o código," +
                "e seus dados serão preenchidos automaticamente.");
        dialogo.show(getSupportFragmentManager(), "dialogo");
    }
}