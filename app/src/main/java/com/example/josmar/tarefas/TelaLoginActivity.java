package com.example.josmar.tarefas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class TelaLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login);
    }

    public void login(View view) {
        Intent vaiPraLista = new Intent(TelaLoginActivity.this, ListaTarefasActivity.class);
        startActivity(vaiPraLista);
        Toast.makeText(this, "Bem vindo Usuário", Toast.LENGTH_SHORT).show();
    }

    public void cadastre(View view) {
        Intent vaiProCadastro = new Intent(TelaLoginActivity.this, CadastroUsuarioActivity.class);
        startActivity(vaiProCadastro);
        Toast.makeText(this, "Cadastre!", Toast.LENGTH_SHORT).show();
    }
}
