package br.com.rocknewventures.estoqueservice.repository;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.rocknewventures.estoque.EstoqueProduto;

@Repository
public class EstoqueRepository {

    public EstoqueProduto obterEstoqueProduto(String sku) {
        EstoqueProduto estoqueProduto = new EstoqueProduto();
        estoqueProduto.setCodigoProduto(new BigInteger("1"));
        estoqueProduto.setQuantidade(new BigInteger("2"));
        estoqueProduto.setSku(UUID.randomUUID().toString());
        return estoqueProduto;
    }

}
