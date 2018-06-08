package com.example.aldoh.bancodedados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class CriaBanco extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "Banco.db";
    public static final String TABELA = "carro";
    public static final String ID = "_id";
    public static final String NOME = "nome";
    public static final String PLACA = "placa";
    public static final String ANO = "ano";
    private static final int VERSAO = 1;

    public CriaBanco(Context context){
        super(context, NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABELA+"(" + ID
                + " integer primary key autoincrement,"
                + NOME + " text," + PLACA
                + " text," + ANO + " text" +")";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);
    }
}