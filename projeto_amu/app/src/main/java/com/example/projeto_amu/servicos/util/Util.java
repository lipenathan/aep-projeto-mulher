package com.example.projeto_amu.servicos.util;

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
