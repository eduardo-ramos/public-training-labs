package br.com.rocknewventures.pedidoservice.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import br.com.rocknewventures.pedidoservice.config.properties.WebServiceConfigProperties;
import lombok.RequiredArgsConstructor;

@EnableWs
@Configuration
@RequiredArgsConstructor
public class WebServiceConfig extends WsConfigurerAdapter {

    private final WebServiceConfigProperties properties;

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean
    public XsdSchema xsdSchema() {
        return new SimpleXsdSchema(new ClassPathResource(properties.getXsdSchema()));
    }

    @Bean("PedidoService")
    public DefaultWsdl11Definition wsdl11Definition(XsdSchema xsdSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName(properties.getWsdlDefinition().getPortName());
        wsdl11Definition.setLocationUri(properties.getLocationUri());
        wsdl11Definition.setTargetNamespace(properties.getWsdlDefinition().getTargetNamespace());
        wsdl11Definition.setSchema(xsdSchema);
        return wsdl11Definition;
    }
}
