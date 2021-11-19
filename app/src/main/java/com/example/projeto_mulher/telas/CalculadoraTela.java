package com.example.projeto_mulher.telas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projeto_mulher.R;
import com.example.projeto_mulher.regras.dominio.calculadora.Calculadora;
import com.example.projeto_mulher.regras.dominio.calculadora.Operacao;
import com.example.projeto_mulher.servicos.repositorio.RepositorioCredencial;

public class CalculadoraTela extends Activity {

    private Calculadora calculadora = new Calculadora();
    private TextView visor;
    private TextView visorPrincipal;
    private RepositorioCredencial repositorioCredencial;
    private String credencial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        try {
            credencial = repositorioCredencial.buscarCredencial();
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        this.visor = (TextView) findViewById(R.id.visor);
        this.visorPrincipal = (TextView) findViewById(R.id.visorPrincipal);
        atualizarVisor();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable("calculadora", this.calculadora);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.getSerializable("calculadora") != null) {
            this.calculadora = (Calculadora) savedInstanceState.getSerializable("calculadora");
            atualizarVisor();
        }
    }

    private void setCaracter(char caracter) {
        try {
            calculadora.setCaracter(caracter);
            atualizarVisor();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getBaseContext(), "Ocorreu um erro!", Toast.LENGTH_SHORT).show();
        }
    }

    private void atualizarVisor() {
        if (this.calculadora != null) {
            visor.setText(calculadora.getValorTexto());
            visorPrincipal.setText(calculadora.getValorTextoPrincipal());
        } else {
            visor.setText("");
            visorPrincipal.setText("0");
        }
    }

    private void setOperacao(Operacao operation) {
        calculadora.setOperacao(operation);
        atualizarVisor();
    }

    public void handleButtonUm(View view) {
        setCaracter('1');
    }

    public void handleButtonDois(View view) {
        setCaracter('2');
    }

    public void handleButtonTres(View view) {
        setCaracter('3');
    }

    public void handleButtonQuatro(View view) {
        setCaracter('4');
    }

    public void handleButtonCinco(View view) {
        setCaracter('5');
    }

    public void handleButtonSeis(View view) {
        setCaracter('6');
    }

    public void handleButtonSete(View view) {
        setCaracter('7');
    }

    public void handleButtonOito(View view) {
        setCaracter('8');
    }

    public void handleButtonNove(View view) {
        setCaracter('9');
    }

    public void handleButtonZero(View view) {
        setCaracter('0');
    }

    public void handleButtonSoma(View view) {
        setOperacao(Operacao.ADICAO);
    }

    public void handleButtonSubtrai(View view) {
        setOperacao(Operacao.SUBTRACAO);
    }

    public void handleButtonMultiplica(View view) {
        setOperacao(Operacao.MULTIPLICACAO);
    }

    public void handleButtonDivide(View view) {
        setOperacao(Operacao.DIVISAO);
    }

    public void handleButtonPorcentagem(View view) {
        setOperacao(Operacao.PORCENTAGEM);
    }

    public void handleButtonVirgula(View view) {
        setCaracter(',');
    }

    public void handleButtonResultado(View view) {
        String senha = calculadora.getValorTexto().replace(".", "").replace(",","");
        if (credencial.equals(senha)) {
            Intent intent = new Intent(this, Principal.class);
            startActivity(intent);
        }
        calculadora.calcular();
        atualizarVisor();
    }

    public void handleButtonLimpar(View view) {
        calculadora = new Calculadora();
        atualizarVisor();
    }

    public void handleButtonDesfazer(View view) {
        try {
            calculadora.removerUltimoCaracter();
            atualizarVisor();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getBaseContext(), "Ocorreu um erro!", Toast.LENGTH_SHORT).show();
        }
    }
}