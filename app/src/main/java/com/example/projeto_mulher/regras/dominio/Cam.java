package com.example.projeto_mulher.regras.dominio;

/**
 * Domínio que representa os dados da central de atendimento a mulher
 * @author Felipe Nathan
 * @version 1.0 11/11/2021
 * @since 11/11/2021
 */
public class Cam {

    private Long id;
    private String contato;
    private String informacoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getInformacoes() {
        return informacoes;
    }

    public void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
    }
}
