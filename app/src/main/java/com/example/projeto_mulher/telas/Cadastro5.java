package com.example.projeto_mulher.telas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.projeto_mulher.R;

/**
 * step 5 -> foto vítima
 */
public class Cadastro5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro5);
    }

    public void irParaPrincipal(View view) {
        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
    }
}