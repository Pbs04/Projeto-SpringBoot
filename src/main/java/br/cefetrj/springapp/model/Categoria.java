package br.cefetrj.springapp.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name = "categoria")
public class Categoria extends EntidadeGenerica{
     private String nome;

    @OneToMany(mappedBy = "categoria")
    private List<Produto> produtos;
}
