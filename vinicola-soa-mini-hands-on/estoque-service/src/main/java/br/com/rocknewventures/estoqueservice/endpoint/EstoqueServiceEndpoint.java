package br.com.rocknewventures.estoqueservice.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.com.rocknewventures.estoque.AtualizarEstoqueProdutoRequest;
import br.com.rocknewventures.estoque.AtualizarEstoqueProdutoResponse;
import br.com.rocknewventures.estoque.ObterEstoqueProdutoRequest;
import br.com.rocknewventures.estoque.ObterEstoqueProdutoResponse;
import br.com.rocknewventures.estoqueservice.repository.EstoqueRepository;
import lombok.RequiredArgsConstructor;


@Endpoint
@RequiredArgsConstructor
public class EstoqueServiceEndpoint {

    private static final String NAMESPACE_URI = "http://rocknewventures.com.br/estoque";

    private final EstoqueRepository repository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ObterEstoqueProdutoRequest")
    @ResponsePayload
    public ObterEstoqueProdutoResponse obterEstoqueProduto(@RequestPayload ObterEstoqueProdutoRequest request) {
        ObterEstoqueProdutoResponse response = new ObterEstoqueProdutoResponse();
        response.setItem(repository.obterEstoqueProduto(request.getSku()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AtualizarEstoqueProdutoRequest")
    @ResponsePayload
    public AtualizarEstoqueProdutoResponse atualizarEstoqueProduto(@RequestPayload AtualizarEstoqueProdutoRequest request) {
        AtualizarEstoqueProdutoResponse response = new AtualizarEstoqueProdutoResponse();
        response.setStatus("PEDIDO CRIADO");
        return response;
    }
}
