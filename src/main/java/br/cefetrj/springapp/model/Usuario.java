package br.cefetrj.springapp.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name = "usuario")
public class Usuario extends EntidadeGenerica{

    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private String tipo;

    @OneToMany(mappedBy = "usuario")
    private List<Pedido> pedidos;
}
