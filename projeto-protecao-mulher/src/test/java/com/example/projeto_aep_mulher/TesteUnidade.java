package com.example.projeto_aep_mulher;

import com.example.projeto_aep_mulher.dominio.Contato;
import com.example.projeto_aep_mulher.dominio.Telefone;
import com.example.projeto_aep_mulher.dominio.Tipo;
import com.example.projeto_aep_mulher.dominio.Vitima;

import org.junit.Assert;
import org.junit.Test;

public class TesteUnidade {

    static Vitima fabricarVtima() {
        Vitima vitima = new Vitima();
        vitima.setNome("Aline");
        vitima.setCpf("000.111.222-33");
        vitima.setEndereco("Rua das mulheres amadas 71");
        try {
            vitima.adicionarTelefone(new Telefone("(43)98422-0022"));
            vitima.adicionarContato(fabricarContato());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vitima;
    }

    static Contato fabricarContato() {
        Contato contato = new Contato();
        contato.setNome("Amigo");
        try {
            contato.adicionarTelefone(new Telefone("(43)99844-3321"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contato;
    }

    @Test
    public void testeTipo() {
        Telefone c = new Telefone();
        c.setTipo(Tipo.MOVEL);
        System.out.println(c.getTipo());
    }

    @Test
    public void validarDadosVitima() {
       Vitima vitima = fabricarVtima();
        try {
            vitima.validarCampos();
        } catch (Exception e) {
            Assert.fail("Deve validar Vítima com dados corretos -" + e.getMessage());
        }
    }

    @Test
    public void validarTipoTelefone() {
        Telefone telefone = new Telefone("(43)3370-3305");
        System.out.println(telefone.getTipo());
    }

}
