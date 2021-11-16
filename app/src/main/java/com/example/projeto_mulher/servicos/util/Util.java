package com.example.projeto_mulher.servicos.util;

import android.widget.EditText;

/**
 * Classe de métodos utilitários para aplicação
 * @author Felipe Nathan
 * @version 1.0 15/11/2021
 * @since  15/11/2021
 */
public class Util {

    /**
     * converte Edit Text para String
     * @param editText
     * @return String
     */
    public static String txToString(EditText editText) {
        return editText.getText().toString();
    }
}
