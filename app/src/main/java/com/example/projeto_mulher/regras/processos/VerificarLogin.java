package com.example.projeto_mulher.regras.processos;

import android.content.Context;

import com.example.projeto_mulher.regras.dominio.Endereco;
import com.example.projeto_mulher.regras.dominio.Telefone;
import com.example.projeto_mulher.regras.dominio.Vitima;
import com.example.projeto_mulher.servicos.repositorio.RepositorioEndereco;
import com.example.projeto_mulher.servicos.repositorio.RepositorioTelefone;
import com.example.projeto_mulher.servicos.repositorio.RepositorioVitima;
import com.example.projeto_mulher.servicos.repositorio.dto.VitimaDto;

import java.util.List;

public class VerificarLogin {

    RepositorioVitima repositorioVitima;
    RepositorioEndereco repositorioEndereco;
    RepositorioTelefone repositorioTelefone;

    public VerificarLogin(Context context) {
        repositorioVitima = new RepositorioVitima(context);
        repositorioEndereco = new RepositorioEndereco(context);
        repositorioTelefone = new RepositorioTelefone(context);
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
}
