package br.cefetrj.springapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.cefetrj.springapp.model.Categoria;

public interface CategoriaRepository extends GenericRepository<Categoria>, JpaSpecificationExecutor<Categoria>{
    public Optional<Categoria> findByNome(String nome);   
}
