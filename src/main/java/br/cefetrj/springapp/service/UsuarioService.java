package br.cefetrj.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.cefetrj.springapp.model.Usuario;
import br.cefetrj.springapp.repository.UsuarioRepository;

@Service
public class UsuarioService implements GenericService<Usuario> {
    @Autowired
    private UsuarioRepository repository;

    public void cadastrar(Usuario entidade){
      this.repository.save(entidade);
    }

    public void atualizar(Usuario entidade){
      this.repository.save(entidade);
    }

    public Page<Usuario> listarTodos(Pageable pageable){
       return this.repository.findAll(pageable);
    }

    public Usuario getById(Long id){
       return this.repository.findById(id).orElse(null);
    }

    public void remover(Usuario entidade){
         this.repository.delete(entidade);
    }

    public Usuario pegaPorCpf(String cpf){
        return this.repository.findByCpf(cpf).orElse(null);
    }
}
