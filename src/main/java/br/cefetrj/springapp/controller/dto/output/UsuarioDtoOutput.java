package br.cefetrj.springapp.controller.dto.output;

import br.cefetrj.springapp.model.Usuario;
import lombok.Data;

@Data
public class UsuarioDtoOutput {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String tipo;

    public UsuarioDtoOutput(Usuario usuario){

        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.cpf = usuario.getCpf();
        this.email = usuario.getEmail();
        this.tipo = usuario.getTipo();
    }
}