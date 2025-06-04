package br.com.rocknewventures.pedidoservice.endpoint;

import java.util.List;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.com.rocknewventures.pedidos.CriarPedidoRequest;
import br.com.rocknewventures.pedidos.CriarPedidoResponse;
import br.com.rocknewventures.pedidos.ListarPedidosRequest;
import br.com.rocknewventures.pedidos.ListarPedidosResponse;
import br.com.rocknewventures.pedidos.Pedido;
import br.com.rocknewventures.pedidoservice.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;


@Endpoint
@RequiredArgsConstructor
public class PedidoServiceEndpoint {

    private static final String NAMESPACE_URI = "http://rocknewventures.com.br/pedidos";

    private final PedidoRepository repository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CriarPedidoRequest")
    @ResponsePayload
    public CriarPedidoResponse criarPedido(@RequestPayload CriarPedidoRequest request) {
        CriarPedidoResponse response = new CriarPedidoResponse();
        response.setCodigoPedido(repository.criarPedido(request.getPedido()).toString());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ListarPedidosRequest")
    @ResponsePayload
    public ListarPedidosResponse listarPedidos(@RequestPayload ListarPedidosRequest request) {
        ListarPedidosResponse response = new ListarPedidosResponse();
        List<Pedido> listaPedidos = repository.listarPedidos(request.getCodigoPedido());
        response.getPedido().addAll(listaPedidos);
        return response;
    }
}
