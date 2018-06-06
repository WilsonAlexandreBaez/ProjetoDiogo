package com.example.josmar.tarefas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Criado por Josmar Saiefert em 03/06/2018.
 */

public class TelaLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login);
    }

    public void login(View view) {

        EditText usuario = findViewById(R.id.tela_login_usuario);
        EditText senha = findViewById(R.id.tela_login_senha);

        String validaUsuario = usuario.getText().toString();
        String validaSenha = senha.getText().toString();

        if (TextUtils.isEmpty(validaUsuario)) {
            usuario.setError("Usuário não pode ser vazio!");
        } else if (TextUtils.isEmpty(validaSenha)) {
            senha.setError("Senha não pode ser vazia!");
        } else {
            Intent vaiPraLista = new Intent(TelaLoginActivity.this, ListaTarefasActivity.class);
            startActivity(vaiPraLista);
            Toast.makeText(this, "Bem vindo Usuário", Toast.LENGTH_SHORT).show();
        }
    }

    public void cadastre(View view) {
        Intent vaiProCadastro = new Intent(TelaLoginActivity.this, CadastroUsuarioActivity.class);
        startActivity(vaiProCadastro);
        Toast.makeText(this, "Cadastre!", Toast.LENGTH_SHORT).show();
    }
}
