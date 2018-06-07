package com.example.josmar.tarefas.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.josmar.tarefas.Modelo.Tarefas;

import java.util.ArrayList;
import java.util.List;

public class DAOTarefas extends SQLiteOpenHelper {
    public DAOTarefas(Context context) {
        super(context, "Aplicativo", null, 1);
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

    public List<Tarefas> listaTarefas() {
        String sql = "SELECT * FROM Tarefas;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql,null);
        List<Tarefas> tarefas = new ArrayList<Tarefas>();

        while (c.moveToNext()){
            Tarefas tarefa = new Tarefas();
            tarefa.setId(c.getInt(c.getColumnIndex("id")));
            tarefa.setIdUsuario(c.getInt(c.getColumnIndex("idUsuario")));
            tarefa.setDescricao(c.getString(c.getColumnIndex("descricao")));
            tarefa.setDataVencimento(c.getString(c.getColumnIndex("vencimento")));

            tarefas.add(tarefa);
        }
        c.close();
        return tarefas;
    }
    public List<Tarefas> buscaTarefas() {
        String sql = "SELECT * FROM Tarefas;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql,null);
        List<Tarefas> tarefas = new ArrayList<Tarefas>();

        while (c.moveToNext()){
            Tarefas tarefa = new Tarefas();
            tarefa.setId(c.getInt(c.getColumnIndex("id")));
            tarefa.setIdUsuario(c.getColumnIndex("idUsuario"));
            tarefa.setDescricao(c.getString(c.getColumnIndex("nome")));
            tarefa.setDataVencimento(c.getString(c.getColumnIndex("endereco")));

            tarefas.add(tarefa);
        }
        c.close();
        return tarefas;
    }
}

