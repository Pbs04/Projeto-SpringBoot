package br.cefetrj.springapp.controller.dto.input;

import br.cefetrj.springapp.model.Usuario;
import lombok.Data;

@Data
public class UsuarioDtoInput {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private String tipo;

    public Usuario build(){

        Usuario usuario = new Usuario();
        usuario.setId(this.id);
        usuario.setNome(this.nome);
        usuario.setCpf(this.cpf);
        usuario.setEmail(this.email);
        usuario.setSenha(this.senha);
        usuario.setTipo(this.tipo);

        return usuario;
    }
}