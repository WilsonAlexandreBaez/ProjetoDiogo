package com.example.josmar.tarefas.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.josmar.tarefas.Modelo.Usuario;

/**
 * Criado por Josmar Saiefert em 03/06/2018.
 */

public class DAOUsuarios extends SQLiteOpenHelper{
    public DAOUsuarios(Context context){
        super(context, "Tarefas", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Usuarios (id INTEGER PRIMARY KEY, usuario TEXT NOT NULL, nome TEXT NOT NULL ,senha TEXT NOT NULL, email TEXT NOT NULL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS Usuarios;";
        db.execSQL(sql);
        onCreate(db);
    }

    public void cadastra(Usuario usuario) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put("usuario", usuario.getUsuario());
        dados.put("nome", usuario.getNome());
        dados.put("senha", usuario.getSenha());
        dados.put("email", usuario.getEmail());

        db.insert("Usuario", null, dados);
    }
}
