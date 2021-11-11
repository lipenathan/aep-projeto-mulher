package com.example.projeto_mulher.regras.dominio;

/**
 * Representa número telefonico
 *
 * @author Felipe Nathan
 * @version 1.0 03/11/2021
 * @since 03/11/2021
 */
public class Telefone {
    private static final String TELEFONE_REGEX = "[(][0-9]{2}[)][3]{2}[0-9]{3}-[0-9]{4}";
    private static final String TELEFONE_MOVEL_REGEX = "[(][0-9]{2}[)][9]{1}[0-9]{4}-[0-9]{4}";
    private Long id;
    private String numero;
    private Tipo tipo;

    public Telefone(String numero) {
        this.numero = numero;
        this.tipo = verificarTipo();
    }

    public Telefone() {
    }

    private Tipo verificarTipo() {
        if (this.numero.matches(TELEFONE_REGEX)) {
            return Tipo.RESIDENCIAL;
        }
        if (this.numero.matches(TELEFONE_MOVEL_REGEX)) {
            return Tipo.MOVEL;
        }
        return null;
    }

    public void validarCampos() throws Exception {
        if (this.numero == null || this.numero.equals("")) {
            throw new Exception("número do telefone é obrigatório");
        }
        if (this.tipo == null) {
            throw new Exception("tipo do telefone é obrigatório");
        }
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

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
