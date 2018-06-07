package com.example.josmar.tarefas.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.josmar.tarefas.Modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Criado por Josmar Saiefert em 03/06/2018.
 */

public class DAOUsuarios extends SQLiteOpenHelper {
    public DAOUsuarios(Context context) {
        super(context, "Tarefas", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Usuarios (id INTEGER PRIMARY KEY, usuario TEXT NOT NULL, senha TEXT NOT NULL);";
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
        dados.put("senha", usuario.getSenha());

        db.insert("Usuarios", null, dados);
    }

    public int Login(String usuario, String senha) {
        SQLiteDatabase db = getReadableDatabase();
        String[] busca = new String[]{usuario, senha};
        try {
            int i = 0;
            Cursor c = null;
            c = db.rawQuery("select * from Usuarios where usuario=? and senha=?", busca);
            c.moveToFirst();
            i = c.getCount();
            c.close();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int verificaSeUsuarioExiste(String usuario) {
        SQLiteDatabase db = getReadableDatabase();
        String[] busca = new String[]{usuario};
        try {
            int i = 0;
            Cursor c = null;
            c = db.rawQuery("select * from Usuarios where usuario=?", busca);
            c.moveToFirst();
            i = c.getCount();
            c.close();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
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
