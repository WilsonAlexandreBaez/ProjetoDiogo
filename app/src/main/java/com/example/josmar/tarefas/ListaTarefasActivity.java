package com.example.josmar.tarefas;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


/**
 * Criado por Josmar Saiefert em 03/06/2018.
 */

public class ListaTarefasActivity extends AppCompatActivity {

    public int carregar() {
        SharedPreferences preferencias = getSharedPreferences("preferencias_usuario", Activity.MODE_PRIVATE);
        return preferencias.getInt("id_usuario", 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_tarefas);
    }

    public void criarTarefa(View view) {
        Intent vaiProCadastro = new Intent(ListaTarefasActivity.this, CadastraTarefasActivity.class);
        startActivity(vaiProCadastro);
    }
}
