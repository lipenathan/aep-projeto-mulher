package com.example.projeto_mulher.servicos.repositorio;

import static com.example.projeto_mulher.servicos.util.Logs.DATABASE_CREATE_TABLE;
import static com.example.projeto_mulher.servicos.util.Logs.DROP_TABLE;
import static com.example.projeto_mulher.servicos.util.Logs.logPassagem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Classe de conexão com banco de dados da aplicação
 * @author Felipe Nathan
 * @version 1.0 13/11/2021
 * @since 13/11/2021
 */
public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "app_mulher.db";
    private static final int DATABASE_VERSION = 1;
    private static final String DROP_TBVITIMA = "DROP TABLE IF EXISTS tb_vitima";
    private static final String DROP_TBENDERECO = "DROP TABLE IF EXISTS tb_endereco";
    private static final String CREATE_TABLE_VITIMA = "CREATE TABLE tb_vitima" +
            "(id_vitima integer primary key autoincrement, nome_vitima text not null, cpf_vitima text not null, " +
            "id_endereco_vitima integer not null, email_vitima text, cod_medida_protetiva text)";

    private static final String CREATE_TABLE_TELEFONE = "CREATE TABLE IF NOT EXISTS tb_telefone" +
            "(id_telefone integer primary key autoincrement, numero_telefone text not null, tipo_telefone text not null," +
            "id_pessoa integer not null, tipo_pessoa text not null)";

    private static final String CREATE_TABLE_ENDERECO = "CREATE TABLE IF NOT EXISTS tb_endereco" +
            "(id_endereco integer primary key autoincrement, estado_endereco text not null, cidade_endereco text not null," +
            "rua_endereco text not null, numero_endereco integer not null, cep_endereco text )";

    private static final String CREATE_TABLE_CONTATO = "CREATE TABLE IF NOT EXISTS tb_contato_vitima" +
            "(id_contato integer primary key autoincrement, nome_contato text not null, cpf_contato text, " +
            "id_endereco_contato integer)";
    private static final String CREATE_TABLE_SUSPEITO = "CREATE TABLE IF NOT EXISTS tb_suspeito" +
            "(id_suspeito integer primary key autoincrement, nome_suspeito text not null, cpf_suspeito text, " +
            "id_endereco_suspeito integer)";

    private static final String CREATE_TABLE_OCORRENCIAS = "CREATE TABLE IF NOT EXISTS tb_ocorrencia" +
            "(id_ocorrencia integer primary key autoincrement, data_ocorrencia text not null, hora_ocorrencia text not null," +
            "descricao_ocorrencia text not null, local_vitima text, local_suspeito text, distancia_ocorrencia real, " +
            "status_ocorrencia text)";

    private static final String CREATE_TABLE_MEDIDA_PROTETIVA = "CREATE TABLE IF NOT EXISTS tb_medida_protetiva" +
            "(cod_medida integer primary key, descricao_medida text)";

    private static final String CREATE_TABLE_CAM = "CREATE TABLE IF NOT EXISTS tb_cam" +
            "(id_cam integer primary key autoincrement, contato_cam text)";

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
//        database.execSQL(DROP_TBVITIMA);
//        logPassagem(DROP_TABLE, "tb_vitima");
//        database.execSQL(DROP_TBENDERECO);
//        logPassagem(DROP_TABLE, "tb_endereco");
        database.execSQL(CREATE_TABLE_VITIMA);
        logPassagem(DATABASE_CREATE_TABLE, "tb_vitima");
        database.execSQL(CREATE_TABLE_TELEFONE);
        logPassagem(DATABASE_CREATE_TABLE, "tb_telefones_vitima");
        database.execSQL(CREATE_TABLE_ENDERECO);
        logPassagem(DATABASE_CREATE_TABLE, "tb_endereco");
        database.execSQL(CREATE_TABLE_CONTATO);
        logPassagem(DATABASE_CREATE_TABLE, "tb_contato_vitima");
        database.execSQL(CREATE_TABLE_SUSPEITO);
        logPassagem(DATABASE_CREATE_TABLE, "tb_suspeito");
        database.execSQL(CREATE_TABLE_OCORRENCIAS);
        logPassagem(DATABASE_CREATE_TABLE, "tb_ocorrencia");
        database.execSQL(CREATE_TABLE_CAM);
        logPassagem(DATABASE_CREATE_TABLE, "tb_cam");
        database.execSQL(CREATE_TABLE_MEDIDA_PROTETIVA);
        logPassagem(DATABASE_CREATE_TABLE, "tb_medida_protetiva");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
