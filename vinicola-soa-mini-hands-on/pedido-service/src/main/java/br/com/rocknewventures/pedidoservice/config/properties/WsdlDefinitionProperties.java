package br.com.rocknewventures.pedidoservice.config.properties;

import lombok.Data;

@Data
public class WsdlDefinitionProperties {
    private String portName;
    private String serviceName;
    private String targetNamespace;
}
