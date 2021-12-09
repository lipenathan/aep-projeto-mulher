package com.example.projeto_mulher.telas;

import static com.example.projeto_mulher.servicos.util.Util.txToString;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
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
import com.example.projeto_mulher.telas.dialogos.Dialogo;

/**
 * Cadastro -> Medida Protetiva
 * @author Felipe Nathan
 * @version 1.0 15/11/2021
 * @since 15/11/2021
 */
public class Cadastro1 extends AppCompatActivity {

    private EditText txMedida;
    private Button btProximo;
    // repositorio de persistência do domínio vítima
    RepositorioVitima repositorioVitima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro1);
//        Toast.makeText(this, "onStop-Cadastro1", Toast.LENGTH_SHORT).show();
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
                } else if (txMedida.getText().toString().length() < 8){
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
        Dialogo dialogo = new Dialogo("INFORMAÇÃO","O aplicativo AMU não necessita de conexão com a internet." +
                "\nPor isso precisamos de alguns dados, para que o seu cadastro seja feito de forma completa.");
        dialogo.show(getSupportFragmentManager(), "dialogo");
    }

    public void dialogoMedidaProtetiva() {
        Dialogo dialogo = new Dialogo("INFORMAÇÃO","Caso já possua uma medida protetiva digite o código," +
                "e seus dados serão preenchidos automaticamente.");
        dialogo.show(getSupportFragmentManager(), "dialogo");
    }
    //lifecycle activity
    @Override
    protected void onStart() {
        super.onStart();
//        Toast.makeText(this, "onStart-Cadastro1", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        Toast.makeText(this, "onResume-Cadastro1", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
//        Toast.makeText(this, "onPause-Cadastro1", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
//        Toast.makeText(this, "onStop-Cadastro1", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
//        Toast.makeText(this, "onRestart-Cadastro1", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        Toast.makeText(this, "onDestroy-Cadastro1", Toast.LENGTH_SHORT).show();
    }
    // utilitarios privados
}