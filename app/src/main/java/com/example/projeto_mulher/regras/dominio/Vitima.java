package com.example.projeto_mulher.regras.dominio;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa a vítima/usuário da aplicação
 * @author Felipe Nathan
 * @since 03/11/2021
 * @version 03/11/2021
 */
public class Vitima extends Pessoa {
    private MedidaProtetiva medidaProtetiva;
    private List<Contato> contatos = new ArrayList<>();

    public void adicionarContato(Contato contato) throws Exception{
        contato.validarCampos();
        this.contatos.add(contato);
    }

    @Override
    public void validarCampos() throws Exception {
        if (this.nome == null || this.nome.equals("")) {
            throw new Exception(gerarMensagemErro("nome"));
        }
        if (this.cpf == null || this.cpf.equals("")) {
            throw new Exception(gerarMensagemErro("cpf"));
        }
        if (this.endereco == null || this.endereco.equals("")) {
            throw new Exception(gerarMensagemErro("endereco"));
        }
        if (this.telefones.isEmpty()) {
            throw new Exception(gerarMensagemErro("telefone"));
        }
    }

    public String getCodMedidaProtetiva() {
        return this.medidaProtetiva.getCodMedida();
    }

    public String getDescricaoMedidaProtetiva() {
        return this.medidaProtetiva.getDescricao();
    }

    public void setMedidaProtetiva(MedidaProtetiva medidaProtetiva) {
        this.medidaProtetiva = medidaProtetiva;
    }
}
