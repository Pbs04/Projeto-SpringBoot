package br.cefetrj.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.cefetrj.springapp.model.Produto;
import br.cefetrj.springapp.repository.ProdutoRepository;

@Service
public class ProdutoService implements GenericService<Produto>
{
    @Autowired
    private ProdutoRepository repository;
    
    public void cadastrar(Produto entidade){
        this.repository.save(entidade);
    }

    public void atualizar(Produto entidade){
        this.repository.save(entidade);
    }

    public Page<Produto> listarTodos(Pageable pageable)
    {
        return this.repository.findAll(pageable);
    }

    public Produto getById(Long id){
        return this.repository.findById(id).orElse(null);
    }

    public void remover(Produto entidade){
        this.repository.delete(entidade);
    }

    public Produto findByNome(String nome){
        return this.repository.findByNome(nome).orElse(null);

    }

}
