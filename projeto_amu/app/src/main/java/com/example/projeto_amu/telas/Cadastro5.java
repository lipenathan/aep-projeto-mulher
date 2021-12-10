package com.example.projeto_amu.telas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.projeto_amu.telas.dialogos.Dialogo;
import com.example.projeto_amu.R;

/**
 * Cadastro -> foto vítima
 * @author Felipe Nathan
 * @version 1.0 15/11/2021
 * @since 15/11/2021
 */
public class Cadastro5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro5);
        dialogoPin2();
        dialogoPin1();
    }

    public void irParaPrincipal(View view) {
        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
        finishAffinity();
    }

    public void dialogoPin1() {
        Dialogo dialogo = new Dialogo("IMPORTANTE!", "Olá, o AMU possui uma calculadora que sobrepõe " +
                "a aplicação principal.\n\nApós concluir seu cadastro, sempre que precisar acessar o aplicativo " +
                "digite o PIN que você escolheu e então o sinal de igual(=) para acessar");
        dialogo.show(getSupportFragmentManager(), "dialogo");
    }

    public void dialogoPin2() {
        Dialogo dialogo = new Dialogo("IMPORTANTE!", "Caso não consiga cadastrar seu PIN, o PIN padrão é '1234'");
        dialogo.show(getSupportFragmentManager(), "dialogo");
    }
}