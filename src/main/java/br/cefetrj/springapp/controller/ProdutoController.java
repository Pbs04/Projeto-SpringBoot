package br.cefetrj.springapp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.cefetrj.springapp.controller.dto.input.ProdutoDtoInput;
import br.cefetrj.springapp.controller.dto.output.ProdutoDtoOutput;
import br.cefetrj.springapp.model.Produto;
import br.cefetrj.springapp.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping("/lista")
    public ResponseEntity<Page<ProdutoDtoOutput>> getProduto(Pageable pageable){
        return ResponseEntity.ok(service.listarTodos(pageable).map(ProdutoDtoOutput::new));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDtoOutput> getById(@PathVariable Long id){ 
        Produto produto = service.getById(id);
        return ResponseEntity.ok(new ProdutoDtoOutput(produto));
    }

    @PostMapping
    public ResponseEntity<ProdutoDtoOutput> cadastrar(@RequestBody ProdutoDtoInput produtoDtoInput){
        this.service.cadastrar(produtoDtoInput.build());
        return ResponseEntity.ok(new ProdutoDtoOutput(produtoDtoInput.build()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDtoOutput> atualizar(
        @PathVariable Long id, @RequestBody ProdutoDtoInput produtoDtoInput)throws Exception{
            
            if(!produtoDtoInput.getId().equals(id)){
                throw new Exception("Erro com id");
            }

            this.service.atualizar(produtoDtoInput.build());
            return ResponseEntity.ok(new ProdutoDtoOutput(produtoDtoInput.build()));
        }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        Produto produto = service.getById(id);
        service.remover(produto);
        return ResponseEntity.noContent().build();
    }
    
}
