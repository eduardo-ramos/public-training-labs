# Vinicola ESB

This is a simple example of an Enterprise Service Bus (ESB) implemented with Spring Boot.

## Architecture

The ESB is composed of the following components:

*   Vinicola ESB: This is the main application that will receive requests from clients and forward them to the appropriate service. It is built using Spring Boot and uses the Apache CXF library to handle SOAP requests.
*   Estoque Service: This service is responsible for managing the inventory of the wine cellar. It is built using Spring Boot and exposes a SOAP interface.
*   Pedido Service: This service is responsible for managing the orders of the wine cellar. It is built using Spring Boot and exposes a SOAP interface.

## Running the application

To run the application, you will need to have the following components installed:

*   Java 17
*   Maven 3.8.6
*   Docker 20.10.17

Once you have these components installed, you can run the application using the following command:

    mvn clean package
    docker-compose up -d

This will start the application and make it available at [http://localhost:8080](http://localhost:8080).

## Using the application

To use the application, you will need to send a SOAP request to the ESB. The ESB will then forward the request to the appropriate service.

For example, to create a new order, you can send the following SOAP request to [http://localhost:8080/pedidos](http://localhost:8080/pedidos):

    <soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope/">
      <soap:Body>
        <CriarPedidoRequest>
          <pedido>
            <idCliente>1</idCliente>
            <codigoProduto>001</codigoProduto>
            <quantidade>2</quantidade>
          </pedido>
        </CriarPedidoRequest>
      </soap:Body>
    </soap:Envelope>

This will create a new order with the specified parameters and return the order code.

## Testing the application

To test the application, you can use the following command:

    mvn test

This will run the unit tests for the application.

## Packaging the application

To package the application, you can use the following command:

    mvn package

This will create a JAR file that can be used to deploy the application.

## Deploying the application

To deploy the application, you can use the following command:

    docker-compose up -d

This will start the application and make it available at [http://localhost:8080](http://localhost:8080).

I hope this helps! Let me know if you have any questions.
