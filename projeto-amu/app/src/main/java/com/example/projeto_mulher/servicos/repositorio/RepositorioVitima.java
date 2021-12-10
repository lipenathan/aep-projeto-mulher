package com.example.projeto_mulher.servicos.repositorio;

import static com.example.projeto_mulher.servicos.util.Logs.INSERT;
import static com.example.projeto_mulher.servicos.util.Logs.INSERT_ERROR;
import static com.example.projeto_mulher.servicos.util.Logs.SELECT_ERROR;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.projeto_mulher.regras.dominio.Vitima;
import com.example.projeto_mulher.servicos.repositorio.dto.VitimaDto;
import com.example.projeto_mulher.servicos.util.Logs;

import java.util.List;

/**
 * acesso ao repositório do domínio vítima
 * @author Felipe Nathan
 * @version 1.0 13/11/2021
 * @since 1.0 13/11/2021
 */
public class RepositorioVitima {

    // atributos de acesso à base de dados
    private SQLiteDatabase database;
    private SQLiteHelper dbHelper;
    private Object[] params;
    // querys
    private static final String INSERT_SEM_MEDIDA = "INSERT INTO tb_vitima(nome_vitima, cpf_vitima, id_endereco_vitima, email_vitima)" +
            "VALUES (?, ?, ?, ?)";
    private static final String SELECT = "SELECT * FROM tb_vitima";

    public RepositorioVitima (Context context) {
        dbHelper = new SQLiteHelper(context);
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Long inserirVitimaSemMedida(Vitima vitima) throws Exception{
        params = new Object[4];
        try {
            open();
            params[0] = vitima.getNome();
            params[1] = vitima.getCpf();
            params[2] = vitima.getEnderecoId();
            params[3] = vitima.getEmail();
            database.execSQL(INSERT_SEM_MEDIDA, params);
            Logs.logCrud(INSERT, "tb_vitima");
            VitimaDto vitimaDto = buscarVitima();
            return vitimaDto.getId();
        } catch (Exception e) {
            Logs.logErro(INSERT_ERROR, e);
            throw new Exception("erro ao inserir dados - " + e.getMessage());
        }
    }

    public VitimaDto buscarVitima() throws Exception {
        try {
            open();
            Cursor cursor = database.rawQuery(SELECT, null);
            if (cursor.getCount() == 0) {
                throw new Exception("Não há dados para serem consultados");
            }
            System.out.println("#### CURSOR COUNT ---> " + cursor.getCount());
            cursor.moveToLast();
            VitimaDto vitima = new VitimaDto();
            vitima.setId(cursor.getLong(0));
            vitima.setNome(cursor.getString(1));
            vitima.setCpf(cursor.getString(2));
            vitima.setId_endereco(cursor.getLong(3));
            vitima.setEmail_vitima(cursor.getString(4));
            vitima.setCod_medida_protetiva(cursor.getString(5));
            cursor.close();
            close();
            return vitima;
        } catch (Exception e) {
            Logs.logErro(SELECT_ERROR, e);
            throw new Exception("Erro ao buscar dados - " + e.getMessage());
        }
    }
}
