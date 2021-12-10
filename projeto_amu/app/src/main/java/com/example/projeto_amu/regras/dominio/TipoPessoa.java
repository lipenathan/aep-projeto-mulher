package com.example.projeto_amu.regras.dominio;

import androidx.annotation.NonNull;

/**
 * Define tipos de pessoa
 * @author Felipe Nathan
 * @version 1.0 15/11/2021
 * @since 15/11/2021
 */
public enum TipoPessoa {
    VITIMA, CONTATO, SUSPEITO;

    @NonNull
    @Override
    public String toString() {
        switch (this) {
            case VITIMA:
                return "vitima";
            case CONTATO:
                return "contato";
            case SUSPEITO:
                return "suspeito";
            default:
                return "tipo não declarado";
        }
    }

    public static TipoPessoa verirficarTipo(String tipo) {
        if (tipo.equals(VITIMA.toString())) {
            return VITIMA;
        }
        if (tipo.equals(CONTATO.toString())) {
            return CONTATO;
        }
        if (tipo.equals(SUSPEITO.toString())) {
            return SUSPEITO;
        }
        return null;
    }
}
