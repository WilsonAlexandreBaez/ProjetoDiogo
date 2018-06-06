package com.example.josmar.tarefas;
import android.widget.EditText;
import com.example.josmar.tarefas.Modelo.Usuario;

/**
 * Criado por Josmar Saiefert em 03/06/2018.
 */

public class CadastroUsuario {

    private final EditText campoUsuario;
    private final EditText campoNome;
    private final EditText campoSenha;
    private final EditText campoEmail;

    public CadastroUsuario(CadastroUsuarioActivity activity) {
        campoUsuario = activity.findViewById(R.id.formulario_usuario);
        campoNome = activity.findViewById(R.id.formulario_nome);
        campoSenha = activity.findViewById(R.id.formulario_senha);
        campoEmail = activity.findViewById(R.id.formulario_email);
    }

    public Usuario bancoUsuario() {
        Usuario usuario = new Usuario();
        usuario.setUsuario(campoUsuario.getText().toString());
        usuario.setNome(campoNome.getText().toString());
        usuario.setSenha(campoSenha.getText().toString());
        usuario.setEmail(campoEmail.getText().toString());
        return usuario;
    }
}
