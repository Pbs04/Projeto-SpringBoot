package br.cefetrj.springapp.controller.dto.output;

import br.cefetrj.springapp.model.Produto;
import lombok.Data;

@Data
public class ProdutoDtoOutput {
    private Long id;
    private String nome;
    private String descricao;
    private double preco;
    private String categoria;

    public ProdutoDtoOutput(Produto produto){
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
        this.categoria = produto.getCategoria() != null
            ? produto.getCategoria().getNome()
            : "";
    }
}
