package com.example.josmar.tarefas.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DAOUsuarios extends SQLiteOpenHelper{
    public DAOUsuarios(Context context){
        super(context, "Usuarios", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Usuarios (id INTEGER PRIMARY KEY, usuario TEXT NOT NULL, senha TEXT NOT NULL, email TEXT NOT NULL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS Usuarios;";
        db.execSQL(sql);
        onCreate(db);
    }
}
