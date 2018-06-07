package com.example.josmar.tarefas;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.josmar.tarefas.DAO.DAOTarefas;
import com.example.josmar.tarefas.Modelo.Tarefas;

import java.util.List;

/**
 * Criado por Josmar Saiefert em 03/06/2018.
 */

public class ListaTarefasActivity extends AppCompatActivity {

    private ListView listaTarefas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_tarefas);

        //listaTarefas = findViewById(R.id.lista_tarefas);
        //registerForContextMenu(listaTarefas);
    }

    public void criarTarefa(View view) {
        Intent vaiProCadastro = new Intent(ListaTarefasActivity.this, CadastraTarefasActivity.class);
        startActivity(vaiProCadastro);
    }

    private void carregaLista() {
        DAOTarefas dao = new DAOTarefas(this);
        List<Tarefas> tarefas = dao.buscaTarefas();
        dao.close();
        ArrayAdapter<Tarefas> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, tarefas);
        listaTarefas.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaLista();

    }

}
