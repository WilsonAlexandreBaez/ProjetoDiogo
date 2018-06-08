package com.example.josmar.tarefas;

import android.content.Intent;
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

    /*private void carregaLista() {
        DAOTarefas dao = new DAOTarefas(this);
        List<Tarefas> tarefas = dao.buscaTarefas();
        dao.close();
        ArrayAdapter<Tarefas> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, tarefas);
        listaTarefas.setAdapter(adapter);
    }
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_tarefas);

        DAOTarefas dao = new DAOTarefas(this);
        List<Tarefas> tarefas = dao.buscaTarefas();
        //dao.close();

        ListView listaTarefas = (ListView) findViewById(R.id.lista_tarefas);
        ArrayAdapter<Tarefas> adapter = new ArrayAdapter<Tarefas>(this,  android.R.layout.simple_list_item_1, tarefas);
        listaTarefas.setAdapter(adapter);

    }

    public void criarTarefa(View view) {
        Intent vaiProCadastro = new Intent(ListaTarefasActivity.this, CadastraTarefasActivity.class);
        startActivity(vaiProCadastro);
    }


    @Override
    protected void onResume() {
        super.onResume();
        //carregaLista();

    }

}
