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
}
