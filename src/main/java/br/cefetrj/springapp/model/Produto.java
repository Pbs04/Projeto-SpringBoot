package br.cefetrj.springapp.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name = "produto")
public class Produto extends EntidadeGenerica{
    
    private String nome;
    private String descricao;
    private double preco;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @OneToMany(mappedBy = "produto")
    private List<PedidoItem> itens;
}
