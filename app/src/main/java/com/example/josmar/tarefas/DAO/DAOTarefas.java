package com.example.josmar.tarefas.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.josmar.tarefas.Modelo.Tarefas;
import com.example.josmar.tarefas.Modelo.Usuario;

public class DAOTarefas extends SQLiteOpenHelper {
    public DAOTarefas(Context context) {
        super(context, "Tarefas", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Tarefas (id INTEGER PRIMARY KEY, descricao TEXT NOT NULL, " +
                "idUsuario INTEGER , FOREIGN KEY(idUsuario) REFERENCES Usuarios(id));";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS Tarefas;";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insereTarefa(Tarefas tarefas) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put("descricao", tarefas.getDescricao());

        db.insert("Tarefas", null, dados);
    }

    /*public List<Usuario> buscaUsuario() {
        String sql = "SELECT * FROM Usuarios;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql,null);
        List<Usuario> usuarios = new ArrayList<Usuario>();

        while (c.moveToNext()){
            Usuario usuario = new Usuario();
            usuario.setId(c.getInt(c.getColumnIndex("id")));
            usuario.setUsuario(c.getString(c.getColumnIndex("usuario")));
            usuario.setNome(c.getString(c.getColumnIndex("nome")));
            usuario.setSenha(c.getString(c.getColumnIndex("senha")));
            usuario.setEmail(c.getString(c.getColumnIndex("email")));

            usuarios.add(usuario);
        }
        c.close();
       return usuarios;
    }
    */
}

