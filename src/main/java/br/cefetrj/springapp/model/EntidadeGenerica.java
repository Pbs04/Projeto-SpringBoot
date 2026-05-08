package br.cefetrj.springapp.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data //Gera os métodos getters, setters, toString, equals e hashCode automaticamente
public abstract class EntidadeGenerica {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//Gera o valor do ID automaticamente
    private Long id;
}
