package com.example.projeto_mulher.telas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.projeto_mulher.R;
import com.example.projeto_mulher.telas.dialogos.Dialogo;

/**
 * step 5 -> foto vítima
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
        this.finishAfterTransition();
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