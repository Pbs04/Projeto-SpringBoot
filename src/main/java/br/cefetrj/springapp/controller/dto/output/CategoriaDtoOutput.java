package br.cefetrj.springapp.controller.dto.output;

import br.cefetrj.springapp.model.Categoria;
import lombok.Data;

@Data
public class CategoriaDtoOutput {
    private Long id;
    private String nome;

    public CategoriaDtoOutput(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }
}
