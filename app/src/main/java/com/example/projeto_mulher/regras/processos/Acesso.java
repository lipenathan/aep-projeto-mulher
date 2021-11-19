package com.example.projeto_mulher.regras.processos;

import android.content.Context;

import com.example.projeto_mulher.regras.dominio.Endereco;
import com.example.projeto_mulher.regras.dominio.Telefone;
import com.example.projeto_mulher.regras.dominio.Vitima;
import com.example.projeto_mulher.servicos.repositorio.RepositorioCredencial;
import com.example.projeto_mulher.servicos.repositorio.RepositorioEndereco;
import com.example.projeto_mulher.servicos.repositorio.RepositorioTelefone;
import com.example.projeto_mulher.servicos.repositorio.RepositorioVitima;
import com.example.projeto_mulher.servicos.repositorio.dto.VitimaDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Acesso {

    RepositorioVitima repositorioVitima;
    RepositorioEndereco repositorioEndereco;
    RepositorioTelefone repositorioTelefone;
    RepositorioCredencial repositorioCredencial;

    public Acesso(Context context) {
        repositorioVitima = new RepositorioVitima(context);
        repositorioEndereco = new RepositorioEndereco(context);
        repositorioTelefone = new RepositorioTelefone(context);
        repositorioCredencial = new RepositorioCredencial(context);
    }

    public Vitima validarLogin() throws Exception {
        VitimaDto vitimaDto = repositorioVitima.buscarVitima();
        Vitima vitima = new Vitima(vitimaDto);
        Endereco endereco = repositorioEndereco.buscarEnderecoPeloId(vitimaDto.getId_endereco());
        List<Telefone> telefones = repositorioTelefone.buscarTelefonesVitima(vitima.getId());
        vitima.setEndereco(endereco);
        vitima.setTelefones(telefones);
        return vitima;
    }

    public void gerarPin() throws Exception {
        String pin = repositorioCredencial.buscarCredencial();
        if (pin == null || pin.isEmpty()) {
            repositorioCredencial.inserirCredencial("1234");
        }
    }

    public void atualizarPin(String senha) throws Exception {
        repositorioCredencial.atualizar(senha);
    }

    public Object passoParado(){
        Object objeto = null;
        try {
            VitimaDto vitimaDto = repositorioVitima.buscarVitima();
            objeto = new Vitima(vitimaDto);
        } catch (Exception e) {
            return objeto;
        }
        try {
            repositorioTelefone.buscarTelefonesVitima(1L);
            objeto = new Telefone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objeto;
    }
}
