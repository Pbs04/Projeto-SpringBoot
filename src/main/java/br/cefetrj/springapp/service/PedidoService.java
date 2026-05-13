package br.cefetrj.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.cefetrj.springapp.model.Pedido;
import br.cefetrj.springapp.model.Usuario;
import br.cefetrj.springapp.repository.PedidoRepository;

@Service
public class PedidoService implements GenericService<Pedido>{
    
    
    @Autowired
    private PedidoRepository repository;

    public void cadastrar(Pedido entidade){
        this.repository.save(entidade);
    }

    public void atualizar(Pedido entidade){
        this.repository.save(entidade);
    }

    public Page<Pedido> listarTodos(Pageable pageable){
        return this.repository.findAll(pageable);
    }

    public Pedido getById(Long id){
        return this.repository.findById(id).orElse(null);
    }

    public void remover(Pedido entidade){
        this.repository.delete(entidade);
    }

    public Pedido pegaPorUsuario(Usuario Usuario){
        return this.repository.findByUsuario(Usuario).orElse(null);

    }
}
