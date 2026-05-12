package br.cefetrj.springapp.controller.dto.output;

import br.cefetrj.springapp.model.Pedido;
import lombok.Data;

@Data
public class PedidoDtoOutput {

    private Long id;
    private String status;

    public PedidoDtoOutput(Pedido pedido){
        this.id = pedido.getId();
        this.status = pedido.getStatus();
    }
}
