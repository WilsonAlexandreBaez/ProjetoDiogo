package com.example.josmar.tarefas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.josmar.tarefas.DAO.DAOUsuarios;

/**
 * Criado por Josmar Saiefert em 03/06/2018.
 */

public class TelaLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login);
    }

    public void botaoLogar(View view) {

        EditText usuario = findViewById(R.id.tela_login_usuario);
        EditText senha = findViewById(R.id.tela_login_senha);

        String validaUsuario = usuario.getText().toString();
        String validaSenha = senha.getText().toString();

        DAOUsuarios daoUsuarios = new DAOUsuarios(this);
        int idUsuario = daoUsuarios.Login(validaUsuario,validaSenha);

        if (TextUtils.isEmpty(validaUsuario)) {
            usuario.setError("Usuário não pode ser vazio!");
        } else if (TextUtils.isEmpty(validaSenha)) {
            senha.setError("Senha não pode ser vazia!");
        } else if (idUsuario != 0){
            Intent vaiPraLista = new Intent(TelaLoginActivity.this, ListaTarefasActivity.class);
            startActivity(vaiPraLista);
            finish();
            Toast.makeText(this, "Bem vindo " + validaUsuario, Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Usuário ou senha Inválidos", Toast.LENGTH_SHORT).show();
        }
    }

    public void cadastre(View view) {
        Intent vaiProCadastro = new Intent(TelaLoginActivity.this, CadastroUsuarioActivity.class);
        startActivity(vaiProCadastro);
        Toast.makeText(this, "Cadastre!", Toast.LENGTH_SHORT).show();
    }
}
