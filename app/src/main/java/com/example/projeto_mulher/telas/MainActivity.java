package com.example.projeto_mulher.telas;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.example.projeto_mulher.regras.dominio.Telefone;
import com.example.projeto_mulher.regras.dominio.Vitima;
import com.example.projeto_mulher.regras.processos.Acesso;
import com.example.projeto_mulher.servicos.repositorio.RepositorioCredencial;
import com.example.projeto_mulher.servicos.repositorio.RepositorioVitima;


public class MainActivity extends AppCompatActivity {

    private Acesso acesso;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        acesso = new Acesso(this);
        try {
            acesso.gerarPin();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
//        Toast.makeText(this, "onCreate-MainActivity", Toast.LENGTH_SHORT).show();
        Intent intent;
        // determinar passo que a vítima parou
        if (acesso.passoParado() == null) {
            intent = new Intent(this, Cadastro1.class);
            startActivity(intent);
            this.finishAfterTransition();
            return;
        }
        if (acesso.passoParado() instanceof Vitima) {
            intent = new Intent(this, Cadastro4.class);
            intent.putExtra("idVitima",((Vitima) acesso.passoParado()).getId());
            startActivity(intent);
            this.finishAfterTransition();
            return;
        }
        if (acesso.passoParado() instanceof Telefone) {
            intent = new Intent(this, Cadastro5.class);
            startActivity(intent);
            this.finishAfterTransition();
            return;
        }
        try {
            acesso.validarLogin();
            intent = new Intent(this, CalculadoraTela.class);
            startActivity(intent);
            this.finishAfterTransition();
        } catch (Exception e) {
            e.printStackTrace();
            intent = new Intent(getApplicationContext(), Cadastro1.class);
            startActivity(intent);
            this.finishAfterTransition();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
//        Toast.makeText(this, "onStart-MainActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        Toast.makeText(this, "onResume-MainActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
//        Toast.makeText(this, "onPause-MainActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
//        Toast.makeText(this, "onStop-MainActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
//        Toast.makeText(this, "onRestart-MainActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        Toast.makeText(this, "onDestroy-MainActivity", Toast.LENGTH_SHORT).show();
    }
}