package br.cefetrj.springapp.controller.dto.input;

import br.cefetrj.springapp.model.Categoria;
import lombok.Data;

@Data
public class CategoriaDtoInput {
    private Long id;
    private String nome;

    public Categoria build(){
        Categoria categoria = new Categoria();
        categoria.setId(this.id);
        categoria.setNome(this.nome);

        return categoria;
    }
}
