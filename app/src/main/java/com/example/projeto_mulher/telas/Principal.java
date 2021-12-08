package com.example.projeto_mulher.telas;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

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

    private static final int PERMISSAO_TELEFONE = 1;

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
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_DENIED) {
            permissaoLigacao();
            return;
        }
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse(TEL_GUARDA_MUNICIPAL));
        startActivity(intent);
    }

    private void permissaoLigacao() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)) {
            new AlertDialog.Builder(this)
                    .setTitle("Permissão necessária")
                    .setMessage("Permitir o Aplicativo AMU acessar o telefone para realizar ligações?")
                    .setPositiveButton("sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(Principal.this, new String[] {Manifest.permission.CALL_PHONE}, PERMISSAO_TELEFONE);
                        }
                    })
                    .setNegativeButton("não", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();
        } else {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CALL_PHONE}, PERMISSAO_TELEFONE);
        }
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSAO_TELEFONE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permissão Concedida", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Permissão Negada", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void pedirAjuda(View view) {
        btAjuda.setImageResource(R.drawable.apoio);
    }
}