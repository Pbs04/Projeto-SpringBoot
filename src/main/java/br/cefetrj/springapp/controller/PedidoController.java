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

import br.cefetrj.springapp.controller.dto.input.PedidoDtoInput;
import br.cefetrj.springapp.controller.dto.output.PedidoDtoOutput;
import br.cefetrj.springapp.model.Pedido;
import br.cefetrj.springapp.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    
    @Autowired
    private PedidoService service;

    @GetMapping("/lista")
    public ResponseEntity<Page<PedidoDtoOutput>> getPedidos(Pageable pageable){
        return ResponseEntity.ok(service.listarTodos(pageable).map(PedidoDtoOutput::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDtoOutput> getById(@PathVariable Long id){
        Pedido pedido = service.getById(id);
        return ResponseEntity.ok(new PedidoDtoOutput(pedido));
    }

    @PostMapping
    public ResponseEntity<PedidoDtoOutput> cadastrar(@RequestBody PedidoDtoInput pedidoDtoInput){
        this.service.cadastrar(pedidoDtoInput.build());
        return ResponseEntity.ok(new PedidoDtoOutput(pedidoDtoInput.build()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDtoOutput> atualizar(@PathVariable Long id, @RequestBody PedidoDtoInput pedidoDtoInput) throws Exception{

        if(!id.equals(pedidoDtoInput.getId())){
            throw new Exception("Erro com id");
        }

        this.service.atualizar(pedidoDtoInput.build());
        return ResponseEntity.ok(new PedidoDtoOutput( pedidoDtoInput.build()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        Pedido pedido = service.getById(id);
        service.remover(pedido);
        return ResponseEntity.noContent().build();
    }
}
