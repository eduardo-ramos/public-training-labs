package br.com.rocknewventures.pedidoservice.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.com.rocknewventures.servicos.pedidos.CriarPedidoRequest;
import br.com.rocknewventures.servicos.pedidos.CriarPedidoResponse;
import br.com.rocknewventures.servicos.pedidos.ListarPedidosRequest;
import br.com.rocknewventures.servicos.pedidos.ListarPedidosResponse;
import br.com.rocknewventures.servicos.pedidos.Pedido;


@Endpoint
public class PedidoEndpoint {
    private static final String NAMESPACE_URI = "http://rocknewventures.com.br/servicos/pedidos";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CriarPedidoRequest")
    @ResponsePayload
    public CriarPedidoResponse criarPedido(@RequestPayload CriarPedidoRequest request) {
        CriarPedidoResponse response = new CriarPedidoResponse();
        response.setCodigoPedido("1");
        response.setStatus("Pedido cadastrado com sucesso para o produto " + request.getPedido().getCodigoProduto());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ListarPedidosRequest")
    @ResponsePayload
    public ListarPedidosResponse listarPedidos(@RequestPayload ListarPedidosRequest request) {
        ListarPedidosResponse response = new ListarPedidosResponse();
        response.getPedidos().add(new Pedido());
        return response;
    }
}
