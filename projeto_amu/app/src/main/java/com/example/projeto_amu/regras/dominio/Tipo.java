package com.example.projeto_amu.regras.dominio;

import androidx.annotation.NonNull;

/**
 * Define tipos de telefone
 * @author Felipe Nathan
 * @version 1.0 15/11/2021
 * @since 15/11/2021
 */
public enum Tipo {
    MOVEL, RESIDENCIAL, COMERCIAL;

    @NonNull
    @Override
    public String toString() {
        switch (this) {
            case MOVEL:
                return "movel";
            case RESIDENCIAL:
                return "residencial";
            case COMERCIAL:
                return "comercial";
            default:
                return "tipo não declarado";
        }
    }

    public static Tipo verirficarTipo(String tipo) {
        if (tipo.equals(MOVEL.toString())) {
            return MOVEL;
        }
        if (tipo.equals(RESIDENCIAL.toString())) {
            return RESIDENCIAL;
        }
        if (tipo.equals(COMERCIAL.toString())) {
            return COMERCIAL;
        }
        return null;
    }
}
