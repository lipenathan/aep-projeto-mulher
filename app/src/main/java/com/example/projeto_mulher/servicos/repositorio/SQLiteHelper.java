package com.example.projeto_mulher.servicos.repositorio;

import static com.example.projeto_mulher.servicos.util.Logs.DATABASE_CREATE_TABLE;
import static com.example.projeto_mulher.servicos.util.Logs.logPassagem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.projeto_mulher.servicos.util.Logs;

/**
 * Classe de conexão com banco de dados da aplicação
 * @author Felipe Nathan
 * @version 1.0 13/11/2021
 * @since 13/11/2021
 */
public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "app_mulher.db";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_TABLE_VITIMA = "CREATE TABLE IF NOT EXISTS tb_vitima" +
            "(id_vitima integer primary key autoincrement, nome_vitima text not null, cpf_vitima text not null, " +
            "id_endereco integer not null, cod_medida_protetiva text)";
    private static final String CREATE_TABLE_TELEFONES_VITIMA = "CREATE TABLE IF NOT EXISTS tb_telefones_vitima" +
            "(id_telefone integer primary key autoincrement, numero_telefone text not null, tipo_telefone text not null)";
    private static final String DATABASE_ENDERECO = "CREATE TABLE IF NOT EXISTS tb_endereco" +
            "(id_endereco integer primary key autoincrement, estado_endereco text not null, cidade_endereco text not null," +
            "rua_endereco text not null, numero_endereco integer not null, cep_endereco text not null)";

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_TABLE_VITIMA);
        logPassagem(DATABASE_CREATE_TABLE, "tb_vitima");
        database.execSQL(CREATE_TABLE_TELEFONES_VITIMA);
        logPassagem(DATABASE_CREATE_TABLE, "tb_telefones_vitima");
        database.execSQL(DATABASE_ENDERECO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
