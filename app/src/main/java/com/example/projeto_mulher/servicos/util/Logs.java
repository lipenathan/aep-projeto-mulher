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
    // base de dados
    public static final String DATABASE_CREATE_TABLE = "DATABASE_CREATE_TABLE - ";
    public static final String DATABASE_INSERT = "DATABASE_INSERT - ";
    public static final String DATABASE_READ = "DATABASE_READ - ";
    public static final String DATABASE_UPDATE = "DATABASE_UPDATE - ";
    public static final String DATABASE_DELETE = "DATABASE_DELETE - ";
    public static final String INSERT = "INSERT -";
    // mensagens de erro
    public static final String INSERT_ERROR = "INSERT ERROR - ";
    public static final String SELECT_ERROR = "SELECT ERROR - ";



    public static void logPassagem(String log, String msg) {
        Log.i(log, msg);
    }

    public static void logErro(String log, Exception exception) {
        Log.i(log, exception.getMessage());
    }

    public static void logCrud(String log, String crud) {
        Log.i(log, crud);
    }
}
