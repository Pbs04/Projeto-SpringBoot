package br.cefetrj.springapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.cefetrj.springapp.model.Produto;

@Repository
public interface ProdutoRepository extends GenericRepository<Produto>,JpaSpecificationExecutor<Produto> {
    public Optional<Produto> findByNome(String nome);
}
