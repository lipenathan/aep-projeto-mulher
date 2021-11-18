package com.example.projeto_mulher.regras.dominio;

import androidx.annotation.NonNull;

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
