package br.cefetrj.springapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name = "pedido_item")
public class PedidoItem extends EntidadeGenerica {
    
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    private int quantidade;
    
    @Column(name = "preco_unitario")
    private double precoUnitario;
    
    private double subtotal;
}
