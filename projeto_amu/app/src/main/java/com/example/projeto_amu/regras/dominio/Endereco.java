package com.example.projeto_amu.regras.dominio;

import java.io.Serializable;

/**
 * Domínio de endereço
 * @author Felipe Nathan
 * @version 1.0 05/11/2021
 * @since 05/11/2021
 */
public class Endereco implements Serializable {

    private static final Long serialVersionUID = 1L;
    private Long id;
    private String estado;
    private String cidade;
    private String cep;
    private String rua;
    private Long numero;

    public void validarCadastro3() throws Exception {
        if (this.estado == null || this.estado.isEmpty()) {
            throw new Exception(gerarMensagemErro("estado"));
        }
        if (this.cidade == null || this.cidade.isEmpty()) {
            throw new Exception(gerarMensagemErro("cidade"));
        }
        if (this.rua == null || this.rua.isEmpty()) {
            throw new Exception(gerarMensagemErro("rua"));
        }
        if (this.numero == null || this.numero <= 0) {
            throw new Exception(gerarMensagemErro("numero"));
        }
    }

    public String getEnderecoPorExtenso() {
        return rua + " nº" + numero + " " + cidade  + ", " + estado + ", " + cep;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Long getNumero() {
        return numero;
    }
    public void setNumero(Long numero) {
        this.numero = numero;
    }


    // utilitários privados
    private String gerarMensagemErro(String campo) {
        return campo + " não preenchido \nou com formato inválido";
    }
}
