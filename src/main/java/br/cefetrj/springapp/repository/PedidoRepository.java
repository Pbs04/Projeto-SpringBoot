package br.cefetrj.springapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.cefetrj.springapp.model.Pedido;
import br.cefetrj.springapp.model.Usuario;

@Repository
public interface PedidoRepository extends GenericRepository<Pedido>, JpaSpecificationExecutor<Pedido>{
    public Optional<Pedido> findByUsuario(Usuario usuario);
}
