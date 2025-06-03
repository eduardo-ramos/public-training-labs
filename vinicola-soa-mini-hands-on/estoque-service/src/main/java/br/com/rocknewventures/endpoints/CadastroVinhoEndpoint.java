package br.com.rocknewventures.endpoints;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.com.vinicola.vinhos.CadastrarVinhoRequest;
import br.com.vinicola.vinhos.CadastrarVinhoResponse;

@Endpoint
public class CadastroVinhoEndpoint {
    private static final String NAMESPACE_URI = "http://vinicola.com.br/vinhos";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CadastrarVinhoRequest")
    @ResponsePayload
    public CadastrarVinhoResponse cadastrarVinho(@RequestPayload CadastrarVinhoRequest request) {
        CadastrarVinhoResponse response = new CadastrarVinhoResponse();
        response.setStatus("Vinho cadastrado com sucesso: " + request.getNome());
        return response;
    }
}
