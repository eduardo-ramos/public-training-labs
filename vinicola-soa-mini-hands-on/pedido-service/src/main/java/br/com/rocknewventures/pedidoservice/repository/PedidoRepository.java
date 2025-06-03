package br.com.rocknewventures.pedidoservice.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.rocknewventures.pedidos.DadosCliente;
import br.com.rocknewventures.pedidos.Endereco;
import br.com.rocknewventures.pedidos.Pedido;

@Repository
public class PedidoRepository {

    public UUID criarPedido(Pedido pedido) {
        return UUID.randomUUID();
    }

    public List<Pedido> listarPedidos(String codigoPedido) {
        Pedido pedido = new Pedido();
        DadosCliente dadosCliente = new DadosCliente();
        Endereco enderecoEntrega = new Endereco();
        Endereco enderecoCobranca = new Endereco();
        
        //Endereço de Entrega
        enderecoEntrega.setBairro("Cidade Monções");
        enderecoEntrega.setCep("12345678");
        enderecoEntrega.setCidade("São Paulo");
        enderecoEntrega.setComplemento("AP 123");
        enderecoEntrega.setEstado("SP");
        enderecoEntrega.setLogradouro("Avenida Paulista");
        enderecoEntrega.setNumero("123");
        enderecoEntrega.setPais("Brasil");
        
        //Endereço de Cobranca
        enderecoCobranca.setBairro("Jardim Paulista");
        enderecoCobranca.setCep("12345678");
        enderecoCobranca.setCidade("São Paulo");
        enderecoCobranca.setComplemento("Casa");
        enderecoCobranca.setEstado("SP");
        enderecoCobranca.setLogradouro("Avenida 9 de Julho");
        enderecoCobranca.setNumero("123");
        enderecoCobranca.setPais("Brasil");

        // dados do cliente
        dadosCliente.setNome("Fulano");
        dadosCliente.setEmail("a@b.com");
        dadosCliente.setTelefone("12345678");
        dadosCliente.setIdCliente(1);
        dadosCliente.setCpfCnpj("123456789");
        dadosCliente.setEnderecoCobranca(enderecoCobranca);
        dadosCliente.setEnderecoEntrega(enderecoEntrega);
        
        // dados do pedido
        pedido.setDadosCliente(dadosCliente);
        
        return List.of(pedido);
    }

}
