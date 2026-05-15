package br.cefetrj.springapp.controller.dto.input;

import br.cefetrj.springapp.model.Pedido;
import br.cefetrj.springapp.model.Usuario;
import lombok.Data;

@Data
public class PedidoDtoInput {
    private Long id;
    private String status;
    private Usuario usuario;

    public Pedido build(){

        Pedido pedido = new Pedido();
        pedido.setId(this.id);
        pedido.setStatus(this.status);
        pedido.setUsuario(this.usuario);

        return pedido;
    }
}
