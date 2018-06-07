package com.example.josmar.tarefas;

import android.widget.EditText;

import com.example.josmar.tarefas.Modelo.Usuario;

public class CadastraTarefas {
    private final EditText campoUsuario;
    private final EditText campoSenha;

    public CadastraTarefas(CadastraTarefasActivity activity) {
        campoUsuario = activity.findViewById(R.id.cadastro_usuario);
        campoSenha = activity.findViewById(R.id.cadastro_senha);
    }

    public Usuario bancoUsuario() {
        Usuario usuario = new Usuario();
        usuario.setUsuario(campoUsuario.getText().toString());
        usuario.setSenha(campoSenha.getText().toString());
        return usuario;
    }
}
