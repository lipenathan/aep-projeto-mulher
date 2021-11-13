package com.example.projeto_mulher.servicos.util;

import android.util.Log;

/**
 * Classe para tratar logs da aplicação
 * @author Felipe Nathan
 * @version 1.0 13/11/2021
 * @since 13/11/2021
 */
public class Logs {

    // tipos de log
    public static final String DATABASE_CREATE_TABLE = "DATABASE_CREATE_TABLE - ";
    public static final String DATABASE_INSERT = "DATABASE_INSERT - ";
    public static final String DATABASE_READ = "DATABASE_READ - ";
    public static final String DATABASE_UPDATE = "DATABASE_UPDATE - ";
    public static final String DATABASE_DELETE = "DATABASE_DELETE - ";


    public static void logPassagem(String log, String msg) {
        Log.i(log, msg);
    }

    public static void logErro(String log, Exception exception) {
        Log.i(log, exception.getMessage());
    }
}
