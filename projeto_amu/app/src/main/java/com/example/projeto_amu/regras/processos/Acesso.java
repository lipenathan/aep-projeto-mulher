package com.example.projeto_amu.regras.processos;

import android.content.Context;

import com.example.projeto_amu.regras.dominio.Endereco;
import com.example.projeto_amu.regras.dominio.Telefone;
import com.example.projeto_amu.servicos.repositorio.RepositorioCredencial;
import com.example.projeto_amu.servicos.repositorio.RepositorioEndereco;
import com.example.projeto_amu.servicos.repositorio.RepositorioTelefone;
import com.example.projeto_amu.servicos.repositorio.RepositorioVitima;
import com.example.projeto_amu.servicos.repositorio.dto.VitimaDto;
import com.example.projeto_amu.regras.dominio.Vitima;

import java.util.List;

/**
 * Processo com regras de negócios de acesso da aplicação
 *
 * @author Felipe Nathan
 * @version 1.0 18/11/2021
 * @since 18/11/2021
 */
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

    /**
     * Valida se o usuário ja se cadastrou
     *
     * @return Vitima com seus dados caso ja tenha feito cadastro
     * @throws Exception
     */
    public Vitima validarLogin() throws Exception {
        VitimaDto vitimaDto = repositorioVitima.buscarVitima();
        Vitima vitima = new Vitima(vitimaDto);
        Endereco endereco = repositorioEndereco.buscarEnderecoPeloId(vitimaDto.getId_endereco());
        List<Telefone> telefones = repositorioTelefone.buscarTelefonesVitima(vitima.getId());
        vitima.setEndereco(endereco);
        vitima.setTelefones(telefones);
        return vitima;
    }

    /**
     * Gera o pin padrão da apliacação
     *
     * @throws Exception
     */
    public void gerarPin() throws Exception {
        String pin = repositorioCredencial.buscarCredencial();
        if (pin == null || pin.isEmpty()) {
            repositorioCredencial.inserirCredencial("1234");
        }
    }

    public void atualizarPin(String senha) throws Exception {
        repositorioCredencial.atualizar(senha);
    }

    /**
     * Verifica qual passo o usuário parou o cadastro
     *
     * @return
     */
    public Object passoParado() {
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
