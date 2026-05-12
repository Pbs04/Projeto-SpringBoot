package br.cefetrj.springapp.controller.dto.input;

import br.cefetrj.springapp.model.Pedido;
import lombok.Data;

@Data
public class PedidoDtoInput {
    private Long id;
    private String status;

    public Pedido build(){

        Pedido pedido = new Pedido();
        pedido.setId(id);
        pedido.setStatus(status);
        return pedido;
    }
}
