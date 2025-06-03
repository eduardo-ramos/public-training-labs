package br.com.rocknewventures.pedidoservice.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.rocknewventures.pedidos.Pedido;

@Repository
public class PedidoRepository {

    public UUID criarPedido(Pedido pedido) {
        return UUID.randomUUID();
    }

    public List<Pedido> listarPedidos(String codigoPedido) {
        Pedido pedido = new Pedido();
        pedido.setIdCliente(1);
        pedido.setCodigoProduto("1");
        pedido.setQuantidade(10);
        return List.of(pedido);
    }

}
