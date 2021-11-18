package com.example.projeto_mulher.telas;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.projeto_mulher.R;
import com.example.projeto_mulher.regras.dominio.Vitima;
import com.example.projeto_mulher.regras.processos.VerificarLogin;


public class MainActivity extends AppCompatActivity {

    private VerificarLogin verificarLogin;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        Toast.makeText(this, "onCreate-MainActivity", Toast.LENGTH_SHORT).show();
        verificarLogin = new VerificarLogin(this);
        Vitima vitima;
        Intent intent;
        try {
            vitima = verificarLogin.validarLogin();
            intent = new Intent(this, Principal.class);
            intent.putExtra("vitima", vitima);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            intent = new Intent(getApplicationContext(), Cadastro1.class);
            startActivity(intent);
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