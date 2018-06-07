package com.example.josmar.tarefas;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.josmar.tarefas.DAO.DAOTarefas;
import com.example.josmar.tarefas.Modelo.Tarefas;


public class CadastraTarefasActivity extends AppCompatActivity {

    public int carregar() {
        SharedPreferences preferencias = getSharedPreferences("preferencias_usuario", Activity.MODE_PRIVATE);
        return preferencias.getInt("id_usuario", 0);
    }

    private CadastraTarefas cadastraTarefas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_tarefas);

        cadastraTarefas = new CadastraTarefas(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_criar_tarefa, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_ok:
                Tarefas tarefas = cadastraTarefas.bancoUsuario();
                DAOTarefas dao = new DAOTarefas(this);
                dao.insereTarefa(tarefas);
                dao.close();

                Toast.makeText(CadastraTarefasActivity.this, "Aluno " + tarefas.getDescricao() + " Salvo!", Toast.LENGTH_SHORT).show();

                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
