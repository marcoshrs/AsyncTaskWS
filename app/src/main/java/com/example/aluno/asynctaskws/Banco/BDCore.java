package com.example.aluno.asynctaskws.Banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by aluno on 13/07/18.
 */

public class BDCore extends SQLiteOpenHelper {
    private final static String NOME_BANCO="cadastro";
    private final static Integer VERSAO_BANCO=1;

    public BDCore(Context context){
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table usuarios(id integer primary key " +
                "autoincrement, " +
                "nome varchar(200)," +
                "idade integer," +
                "sexo varchar(100));");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table usuarios");
        onCreate(db);
    }
}
