package com.example.projeto_mulher.servicos.repositorio;

import static com.example.projeto_mulher.regras.dominio.TipoPessoa.VITIMA;
import static com.example.projeto_mulher.servicos.util.Logs.INSERT_ERROR;
import static com.example.projeto_mulher.servicos.util.Logs.SELECT_ERROR;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.projeto_mulher.regras.dominio.Telefone;
import com.example.projeto_mulher.regras.dominio.Tipo;
import com.example.projeto_mulher.regras.dominio.TipoPessoa;
import com.example.projeto_mulher.servicos.util.Logs;

import java.util.ArrayList;
import java.util.List;

/**
 * Acesso ao repositório de domínio telefone
 *
 * @author Felipe Nathan
 * @version 1.0 16/11/2021
 * @since 16/11/2021
 */
public class RepositorioTelefone {

    // querys
    private static final String INSERT = "INSERT INTO tb_telefone(numero_telefone, tipo_telefone, id_pessoa, tipo_pessoa) " +
            "VALUES(?, ?, ?, ?)";
    private static final String SELECT_TELEFONES_VITIMA = "SELECT * FROM tb_telefone WHERE id_pessoa = ? AND tipo_pessoa = ?";
    private static final String SELECT_IDS = "SELECT id_telefone FROM tb_telefone";
    // atributos de acesso à base de dados
    private SQLiteDatabase database;
    private SQLiteHelper dbHelper;
    private Object[] params;

    public RepositorioTelefone(Context context) {
        dbHelper = new SQLiteHelper(context);
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Long inserirTelefone(Telefone telefone) throws Exception {
        params = new Object[4];
        try {
            open();
            params[0] = telefone.getNumero();
            params[1] = telefone.getTipo();
            params[2] = telefone.getIdPessoa();
            params[3] = telefone.getTipoPessoa();
            database.execSQL(INSERT, params);
            Logs.logCrud(INSERT, "tb_telefone");
            close();
            return getUltimoId();
        } catch (Exception e) {
            Logs.logErro(INSERT_ERROR, e);
            throw new Exception("erro ao inserir dados - " + e.getMessage());
        }
    }

    public List<Telefone> buscarTelefonesVitima(Long id) throws Exception {
        params = new String[2];
        params[0] = id.toString();
        params[1] = VITIMA.toString();
        List<Telefone> telefones = new ArrayList<>();
        try {
            open();
            Cursor cursor = database.rawQuery(SELECT_TELEFONES_VITIMA, (String[]) params);
            if (cursor.getCount() == 0) {
                Exception exception = new Exception("Não há dados para serem consultados");
                Logs.logErro(SELECT_ERROR, exception);
                throw exception;
            }
            cursor.moveToFirst();
            while (cursor.isAfterLast()) {
                cursor.moveToNext();
                Telefone telefone = new Telefone();
                telefone.setId(cursor.getLong(0));
                telefone.setNumero(cursor.getString(1));
                telefone.setTipo(Tipo.verirficarTipo(cursor.getString(2)));
                telefone.setIdPessoa(cursor.getLong(3));
                telefone.setTipoPessoa(TipoPessoa.verirficarTipo(cursor.getString(4)));
                telefones.add(telefone);
            }
            cursor.close();
            close();
            return telefones;
        } catch (Exception e) {
            Logs.logErro(SELECT_ERROR, e);
            throw new Exception("Erro ao buscar dados - " + e.getMessage());
        }
    }

    public Long getUltimoId() throws Exception {
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
}
