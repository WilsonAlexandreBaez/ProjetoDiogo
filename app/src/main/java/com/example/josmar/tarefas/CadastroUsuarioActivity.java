package com.example.josmar.tarefas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.josmar.tarefas.DAO.DAOUsuarios;
import com.example.josmar.tarefas.Modelo.Usuario;

import java.util.regex.Pattern;

/**
 * Criado por Josmar Saiefert em 03/06/2018.
 */

public class CadastroUsuarioActivity extends AppCompatActivity {

    private CadastroUsuario cadastro;

    private boolean emailValido(String email) {
        Pattern padrao = Patterns.EMAIL_ADDRESS;
        return padrao.matcher(email).matches();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

       cadastro = new CadastroUsuario(this);
    }

    public void cadastre(View view) {

        EditText campoUsr = findViewById(R.id.formulario_usuario);
        EditText nome = findViewById(R.id.formulario_nome);
        EditText senha = findViewById(R.id.formulario_senha);
        EditText confirmaSenha = findViewById(R.id.formulario_confirma_senha);
        EditText email = findViewById(R.id.formulario_email);

        String validaUsuario = campoUsr.getText().toString();
        String validaNome = nome.getText().toString();
        String validaSenha = senha.getText().toString();
        String validaSenha2 = confirmaSenha.getText().toString();
        String validaEmail = email.getText().toString();
        boolean emailValido = emailValido(validaEmail);

        if (TextUtils.isEmpty(validaUsuario)) {
            campoUsr.setError("Usuário não pode ser vazio!");
        } else if (TextUtils.isEmpty(validaNome)) {
            nome.setError("Nome não pode ser vazio!");
        } else if (TextUtils.isEmpty(validaSenha)) {
            senha.setError("Senha não pode ser vazia!");
            return;
        } else if (TextUtils.isEmpty(validaSenha2)) {
            confirmaSenha.setError("Senha não pode ser vazia!");
            return;
        } else if (TextUtils.isEmpty(validaSenha) && TextUtils.isEmpty(validaSenha2)) {
            senha.setError("Senha não pode ser vazia!");
            confirmaSenha.setError("Senha não pode ser vazia!");
            return;
        } else if (TextUtils.isEmpty(validaEmail)) {
            email.setError("E-mail não pode ser vazio");
            return;
        } else if (emailValido == false) {
            email.setError("E-mail inválido");
            return;
        } else if (validaSenha.equals(validaSenha2)) {
            Usuario usuario = cadastro.bancoUsuario();
            DAOUsuarios dao = new DAOUsuarios(this);
            dao.cadastra(usuario);
            dao.close();
            Toast.makeText(this, "Usuário Cadastrado com Sucesso!", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "ISHE!", Toast.LENGTH_SHORT).show();
            senha.setError("Senhas não batem!");
            confirmaSenha.setError("Senhas não batem!");
            return;
        }
    }
}
