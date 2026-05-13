package br.cefetrj.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.cefetrj.springapp.model.Categoria;
import br.cefetrj.springapp.repository.CategoriaRepository;

@Service
public class CategoriaService implements GenericService<Categoria> {
    @Autowired
    private CategoriaRepository repository;

     public void cadastrar(Categoria entidade){
      this.repository.save(entidade);
    }

    public void atualizar(Categoria entidade){
      this.repository.save(entidade);
    }

    public Page<Categoria> listarTodos(Pageable pageable){
       return this.repository.findAll(pageable);
    }

    public Categoria getById(Long id){
       return this.repository.findById(id).orElse(null);
    }

    public void remover(Categoria entidade){
         this.repository.delete(entidade);
    }

    public Categoria pegaPorNome(String nome){
        return this.repository.findByNome(nome).orElse(null);
    }
    
}
