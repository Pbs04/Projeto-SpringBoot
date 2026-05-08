package br.cefetrj.springapp.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table (name = "pedido")
public class Pedido extends EntidadeGenerica {
    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String status;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PedidoItem> itens;
}

