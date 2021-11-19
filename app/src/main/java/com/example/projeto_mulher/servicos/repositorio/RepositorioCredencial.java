package com.example.projeto_mulher.servicos.repositorio;

import static com.example.projeto_mulher.servicos.util.Logs.INSERT_ERROR;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.projeto_mulher.servicos.util.Logs;

/**
 * acesso ao repositório da credencial da vitima
 *
 * @author Felipe Nathan
 * @version 1.0 18/11/2021
 * @since 18/11/2021
 */
public class RepositorioCredencial {

    // querys
    private static final String INSERT = "INSERT INTO tb_credencial(senha)" +
            "VALUES (?)";
    private static final String UPDATE = "UPDATE tb_credencial SET senha = ? WHERE id_credencial = ?";
    private static final String SELECT = "SELECT senha FROM tb_credencial";
    // atributos de acesso à base de dados
    private SQLiteDatabase database;
    private SQLiteHelper dbHelper;
    private Object[] params;

    public RepositorioCredencial(Context context) {
        dbHelper = new SQLiteHelper(context);
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public void inserirCredencial(String senha) throws Exception {
        params = new Object[1];
        try {
            open();
            params[0] = senha;
            database.execSQL(INSERT, params);
            Logs.logCrud(Logs.INSERT, "tb_credencial");
            close();
        } catch (Exception e) {
            Logs.logErro(INSERT_ERROR, e);
            throw new Exception("erro ao inserir dados - " + e.getMessage());
        }
    }

    public void atualizar(String senha) throws Exception {
        params = new Object[2];
        params[0] = senha;
        params[1] = 1;
        try {
            open();
            params[0] = senha;
            database.execSQL(UPDATE, params);
            Logs.logCrud(Logs.UPDATE, "tb_credencial");
            close();
        } catch (Exception e) {
            Logs.logErro(Logs.UPDATE_ERROR, e);
            throw new Exception("erro ao inserir dados - " + e.getMessage());
        }
    }

    public String buscarCredencial() throws Exception {
        open();
        Cursor cursor = database.rawQuery(SELECT, null);
        if (cursor.getCount() == 0) return null;
        if (cursor.getCount() > 1) throw new Exception("Mais de uma credencial encontrada");
        cursor.moveToFirst();
        String senha = cursor.getString(0);
        cursor.close();
        close();
        return senha;
    }
}
