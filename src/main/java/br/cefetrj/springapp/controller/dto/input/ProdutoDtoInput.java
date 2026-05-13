package br.cefetrj.springapp.controller.dto.input;

import br.cefetrj.springapp.model.Produto;
import lombok.Data;

@Data
public class ProdutoDtoInput {
    private Long id;
    private String nome;
    private String descricao;
    private double preco;

    public Produto build(){
        Produto produto = new Produto();
        produto.setId(this.id);
        produto.setNome(this.nome);
        produto.setDescricao(this.descricao);
        produto.setPreco(this.preco);
        return produto;
    }

}
