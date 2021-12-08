package com.example.projeto_mulher.servicos.util;

import android.widget.EditText;

/**
 * Classe de métodos utilitários para aplicação
 * @author Felipe Nathan
 * @version 1.0 15/11/2021
 * @since  15/11/2021
 */
public class Util {

    /** Armazena padrão para validação de nome e sobre nome. */
    public static final String NOME_REGEX = "[a-zA-Z]{3,}\\s[a-zA-Z]{3,}[\\sa-zA-Z]*";
    /** Armazena padrão para validação de e-mail. */
    public static final String EMAIL_REGEX = ".{2,}@.{5,20}[.]com";
    /** Armazena padrão para validação de alfabéticos. */
    public static final String ALFABETICO_REGEX = "[a-zA-Z]*";
    /** Armazena padrão para validação de telefone fixo. */
    public static final String FIXO_REGEX = "[(][0-9]{2}[)][3]{2}[0-9]{3}-[0-9]{4}";
    /** Armazena padrão para validação de telefone movel. */
    public static final String MOVEL_REGEX = "[(][0-9]{2}[)][9]{1}[0-9]{4}-[0-9]{4}";

    public static boolean apenasAlfabetico(String texto) {
        if(texto.matches(ALFABETICO_REGEX)) {
            return true;
        }
        return false;
    }

    /**
     * converte Edit Text para String
     * @param editText
     * @return String
     */
    public static String txToString(EditText editText) {
        return editText.getText().length() > 0? editText.getText().toString() : "";
    }

    /**
     * converte Edit Text para Long
     * @param editText
     * @return Long
     */
    public static Long txToLong(EditText editText) {
        return editText.getText().length() > 0? Long.valueOf(editText.getText().toString()) : 0;
    }
}
