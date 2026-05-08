package br.cefetrj.springapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.cefetrj.springapp.model.EntidadeGenerica;


//Fornece métodos para realizar operações de CRUD (Create, Read, Update, Delete) em entidades genéricas. O tipo genérico T é restrito a ser uma subclasse de EntidadeGenerica, garantindo que apenas entidades que herdam de EntidadeGenerica possam ser manipuladas por este repositório.
public interface GenericRepository<T extends EntidadeGenerica> 
extends CrudRepository<T, Long>, PagingAndSortingRepository<T, Long> {
    
}
