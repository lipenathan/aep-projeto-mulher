package com.example.projeto_mulher.regras.dominio;

import java.io.Serializable;

/**
 * Classe que representa a medida protetiva da vítima
 * @author Felipe Nathan
 * @version 1.0 13/11/2021
 * @since 13/11/2021
 */
public class MedidaProtetiva implements Serializable {

    private static final Long serialVersionUID = 1L;
    private String codMedida;
    private String descricao;

    public MedidaProtetiva(String codMedida, String descricao) {
        this.codMedida = codMedida;
        this.descricao = descricao;
    }

    public MedidaProtetiva(String codMedida) {
        this.codMedida = codMedida;
    }

    public MedidaProtetiva() {
    }

    @Override
    public String toString() {
        return "MedidaProtetiva{" +
                "codMedida='" + codMedida + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    public String getCodMedida() {
        return codMedida;
    }

    public void setCodMedida(String codMedida) {
        this.codMedida = codMedida;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
