package com.example.baez.agenda.codigo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    static DBHelper instance;

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    private static DBHelper getInstance(Context context) {
        if(instance == null) {
            instance = new DBHelper(context, "TAREFAS_DIOGO", null,1);
        }
        return instance;
    }

    public static SQLiteDatabase getBancoLeitura(Context context){
        return getInstance(context).getReadableDatabase();
    }

    public static SQLiteDatabase getBancoEscrita(Context context){
        return getInstance(context).getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE TAREFAS (ID INTEGER PRIMARY KEY, descricao TEXT NOT NULL, " +
                "IDUSUARIO INTEGER , FOREIGN KEY(IDUSUARIO) REFERENCES USER(ID));";
        db.execSQL(sql);
        sql = "CREATE TABLE USUARIOS (ID INTEGER PRIMARY KEY, USUARIO TEXT NOT NULL, SENHA TEXT NOT NULL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
