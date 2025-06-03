package br.com.rocknewventures.pedidoservice.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties("br.com.rocknewventures.pedidoservice.config.webservice")
@Data
public class WebServiceConfigProperties {

    private String locationUri;
    private String xsdSchema;
    private WsdlDefinitionProperties wsdlDefinition;

}
