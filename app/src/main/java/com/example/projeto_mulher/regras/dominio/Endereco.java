package com.example.projeto_mulher.regras.dominio;

/**
 * Domínio de endereços
 * @author Felipe Nathan
 * @version 1.0 05/11/2021
 * @since 05/11/2021
 */
public class Endereco {

    private Long id;
    private String estado;
    private String cidade;
    private String cep;
    private String rua;
    private Long numero;

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
}
