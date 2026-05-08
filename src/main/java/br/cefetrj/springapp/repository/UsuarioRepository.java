package br.cefetrj.springapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.cefetrj.springapp.model.Usuario;

@Repository 
public interface UsuarioRepository extends GenericRepository<Usuario>, JpaSpecificationExecutor<Usuario> {
    public Optional<Usuario> findByCpf(String cpf);
}
