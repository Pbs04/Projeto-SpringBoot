package br.cefetrj.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.cefetrj.springapp.controller.dto.input.UsuarioDtoInput;
import br.cefetrj.springapp.controller.dto.output.UsuarioDtoOutput;
import br.cefetrj.springapp.model.Usuario;
import br.cefetrj.springapp.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/lista")
    public ResponseEntity<Page<UsuarioDtoOutput>> getUsuarios(Pageable pageable){
        return ResponseEntity.ok(service.listarTodos(pageable).map(UsuarioDtoOutput::new));
    }

    @PostMapping
    public ResponseEntity<UsuarioDtoOutput> cadastrar(@RequestBody UsuarioDtoInput usuarioDtoInput){
        this.service.cadastrar(usuarioDtoInput.build());
        return ResponseEntity.ok(new UsuarioDtoOutput(usuarioDtoInput.build()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDtoOutput> atualizar(
        @PathVariable Long id, 
        @RequestBody UsuarioDtoInput usuarioDtoInput) throws Exception{
        
        if(!usuarioDtoInput.getId().equals(id)){
            throw new Exception("Erro com id");
        }
        
        this.service.atualizar(usuarioDtoInput.build());
        return ResponseEntity.ok(new UsuarioDtoOutput(usuarioDtoInput.build()));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        Usuario usuario = service.getById(id);
        service.remover(usuario);
        return ResponseEntity.noContent().build();
    }

}
