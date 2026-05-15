package br.cefetrj.springapp.controller.dto.output;

import br.cefetrj.springapp.model.Pedido;
import lombok.Data;

@Data
public class PedidoDtoOutput {

    private Long id;
    private String status;
    private String usuario;

    public PedidoDtoOutput(Pedido pedido){
        this.id = pedido.getId();
        this.status = pedido.getStatus();
        this.usuario = pedido.getUsuario() != null
        ? pedido.getUsuario().getNome(): "";
    }
}
