package br.cefetrj.springapp.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.cefetrj.springapp.model.EntidadeGenerica;

//sempre vai chamar o Service ao invez do Repository, o Service é a camada de negócio, onde ficam as regras de negócio, e o Repository é a camada de acesso a dados, onde ficam as operações de CRUD (Create, Read, Update, Delete) e consultas ao banco de dados. O Service chama o Repository para realizar as operações de acesso a dados, e o Repository é responsável por interagir com o banco de dados.

public interface GenericService<T extends EntidadeGenerica> {

   public void cadastrar(T entidade);

    public void atualizar(T entidade);

    public Page<T> listarTodos(Pageable pageable);

    public T getById(Long id);

    public void remover(T entidade);
}