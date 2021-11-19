package com.example.projeto_mulher.regras.dominio;

import static com.example.projeto_mulher.servicos.util.Util.FIXO_REGEX;
import static com.example.projeto_mulher.servicos.util.Util.MOVEL_REGEX;

import java.io.Serializable;

/**
 * Representa número telefonico
 *
 * @author Felipe Nathan
 * @version 1.0 03/11/2021
 * @since 03/11/2021
 */
public class Telefone implements Serializable {

    private static final Long serialVersionUID = 1L;
    private Long id;
    private String numero;
    private Tipo tipo;
    private Long idPessoa;
    private TipoPessoa tipoPessoa;

    public Telefone(String numero, Long idPessoa, TipoPessoa tipoPessoa) {
        this.numero = numero;
        this.idPessoa = idPessoa;
        this.tipoPessoa = tipoPessoa;verificarTipo();
    }

    public Telefone(String numero) {
        this.numero = numero;
        verificarTipo();
    }

    public Telefone() {
    }

    private void verificarTipo() {
        if (this.numero.matches(FIXO_REGEX)) {
            this.tipo =  Tipo.RESIDENCIAL;
            return;
        }
        if (this.numero.matches(MOVEL_REGEX)) {
            this.tipo = Tipo.MOVEL;
        }
    }

    public void validarCampos() throws Exception {
        if (this.numero == null || this.numero.equals("")) {
            throw new Exception("número do telefone é obrigatório");
        }
        if (this.tipo == null) {
            throw new Exception("tipo do telefone é obrigatório");
        }
    }

    @Override
    public String toString() {
        return "Telefone{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", tipo=" + tipo +
                ", idPessoa=" + idPessoa +
                ", tipoPessoa=" + tipoPessoa +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }
}
