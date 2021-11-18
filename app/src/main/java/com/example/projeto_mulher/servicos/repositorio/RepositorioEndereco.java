package com.example.projeto_mulher.servicos.repositorio;

import static com.example.projeto_mulher.servicos.util.Logs.INSERT_ERROR;
import static com.example.projeto_mulher.servicos.util.Logs.SELECT_ERROR;
import static com.example.projeto_mulher.servicos.util.Logs.logErro;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.projeto_mulher.regras.dominio.Endereco;
import com.example.projeto_mulher.servicos.util.Logs;

/**
 * Acesso ao repositório de domínio telefone
 *
 * @author Felipe Nathan
 * @version 1.0 16/11/2021
 * @since 16/11/2021
 */
public class RepositorioEndereco {

    // querys
    private static final String INSERT = "INSERT INTO tb_endereco(estado_endereco, cidade_endereco, rua_endereco, numero_endereco) " +
            "VALUES(?, ?, ?, ?)";
    private static final String SELECT_IDS = "SELECT id_endereco FROM tb_endereco";
    private static final String SELECT_COM_ID = "SELECT * FROM tb_endereco WHERE id_endereco = ?";
    // atributos de acesso à base de dados
    private SQLiteDatabase database;
    private SQLiteHelper dbHelper;
    private Object[] params;

    public RepositorioEndereco(Context context) {
        dbHelper = new SQLiteHelper(context);
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Long inserirEndereco(Endereco endereco) throws Exception {
        params = new Object[4];
        try {
            open();
            params[0] = endereco.getEstado();
            params[1] = endereco.getCidade();
            params[2] = endereco.getRua();
            params[3] = endereco.getNumero();
            database.execSQL(INSERT, params);
            Logs.logCrud(INSERT, "tb_endereco");
            close();
            return buscarUltimoId();
        } catch (Exception e) {
            Logs.logErro(INSERT_ERROR, e);
            throw new Exception("erro ao inserir dados - " + e.getMessage());
        }
    }

    public Long buscarUltimoId() throws Exception {
        long id;
        try {
            open();
            Cursor cursor = database.rawQuery(SELECT_IDS, null);
            if (cursor.getCount() == 0) {
                throw new Exception("Não há dados para serem consultados");
            }
            cursor.moveToLast();
            id = cursor.getLong(0);
            cursor.close();
            close();
            return id;
        } catch (Exception e) {
            Logs.logErro(SELECT_ERROR, e);
            throw new Exception("Erro ao buscar último Id - " + e.getMessage());
        }
    }

    public Endereco buscarEnderecoPeloId(Long id) throws Exception {
        Endereco endereco = new Endereco();
        params = new String[1];
        params[0] = id.toString();
        open();
        try {
            Cursor cursor = database.rawQuery(SELECT_COM_ID, (String[]) params);
            cursor.moveToFirst();
            endereco.setId(cursor.getLong(0));
            endereco.setEstado(cursor.getString(1));
            endereco.setCidade(cursor.getString(2));
            endereco.setRua(cursor.getString(3));
            endereco.setNumero(cursor.getLong(4));
            cursor.close();
            close();
        } catch (Exception e) {
            logErro(SELECT_ERROR, e);
            throw new Exception("Erro ao buscar pelo id");
        }
        return endereco;
    }
}
