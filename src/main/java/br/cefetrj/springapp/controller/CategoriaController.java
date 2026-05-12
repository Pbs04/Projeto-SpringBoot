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

import br.cefetrj.springapp.controller.dto.input.CategoriaDtoInput;
import br.cefetrj.springapp.controller.dto.output.CategoriaDtoOutput;
import br.cefetrj.springapp.model.Categoria;
import br.cefetrj.springapp.service.CategoriaService;

@RestController // Anotação para indicar que esta classe é um controlador REST
@RequestMapping("/categorias") // Define o caminho base para as rotas deste controlador
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping("/lista")
    public ResponseEntity<Page<CategoriaDtoOutput>> getCategorias(Pageable pageable){
        return ResponseEntity.ok(service.listarTodos(pageable).map(CategoriaDtoOutput::new));
    }

    @PostMapping
    public ResponseEntity<CategoriaDtoOutput> cadastrar(@RequestBody CategoriaDtoInput categoriaDtoInput){
        this.service.cadastrar(categoriaDtoInput.build());
        return ResponseEntity.ok(new CategoriaDtoOutput(categoriaDtoInput.build()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDtoOutput> atualizar(
        @PathVariable Long id,
        @RequestBody CategoriaDtoInput categoriaDtoInput
    ) throws Exception{
        if(!categoriaDtoInput.getId().equals(id)){
            throw new Exception("Erro com id");
        }

        this.service.atualizar(categoriaDtoInput.build());
        return ResponseEntity.ok((new CategoriaDtoOutput(categoriaDtoInput.build())));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        Categoria categoria = service.getById(id);
        service.remover(categoria);
        return ResponseEntity.noContent().build();
    }
    
}
