package com.example.projeto_mulher.telas;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projeto_mulher.R;
import com.example.projeto_mulher.regras.dominio.Vitima;
import com.example.projeto_mulher.servicos.repositorio.RepositorioVitima;
import com.example.projeto_mulher.servicos.repositorio.dto.VitimaDto;

public class Principal extends AppCompatActivity {

    // repositórios
    private RepositorioVitima repositorioVitima;
    private Vitima vitima;
    private TextView txUsuario;
    private ImageView btAjuda;
    private ImageView btGuarda;
    private String TEL_GUARDA_MUNICIPAL = "tel:(43) 3372-4675";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        repositorioVitima = new RepositorioVitima(this);
        VitimaDto vitimaDto;
        try {
            vitimaDto = repositorioVitima.buscarVitima();
            vitima = new Vitima(vitimaDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        txUsuario = findViewById(R.id.txUsuario);
        String[] nome = vitima.getNome().split(" ");
        String ola = "Olá " + nome[0];
        txUsuario.setText(ola);
        btAjuda = findViewById(R.id.btAjuda);
        btGuarda = findViewById(R.id.btGuarda);
    }

    public void ligarParaGuarda(View view) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse(TEL_GUARDA_MUNICIPAL));
        startActivity(intent);
    }

    public void pedirAjuda(View view) {
        btAjuda.setImageResource(R.drawable.apoio);
    }
}