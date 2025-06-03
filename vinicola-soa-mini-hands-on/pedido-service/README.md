# Pedidos Service

This is a Spring Boot application that provides a simple SOAP-based web service to manage orders.

## Running the application

### Prerequisites

* Java 17
* Maven 3.8.6 or later

### Steps

1. Clone the repository:

git clone https://github.com/rocknewventures/pedidos-service.git

2. Change into the project directory:

cd pedidos-service

3. Build the project using Maven:

mvn clean package

4. Run the application:

java -jar target/pedidos-service-1.0-SNAPSHOT.jar

5. Open a web browser and navigate to [http://localhost:8080/pedidos](http://localhost:8080/pedidos)

6. You should see a page with a link to the WSDL of the service.

7. You can use a tool like SoapUI to test the service.

## Testing the application

You can use the following SoapUI project to test the application:

* [pedidos-service-soapui-project.xml](https://github.com/rocknewventures/pedidos-service/blob/main/pedidos-service-soapui-project.xml)

## Deploying the application

You can deploy the application to a cloud platform like Heroku or Google Cloud Platform.

### Heroku

1. Create a Heroku app:

heroku create

2. Set the `JAVA_TOOL_OPTIONS` environment variable:

heroku config:set JAVA_TOOL_OPTIONS="-Xmx512m -Xss512k"

3. Deploy the application:

git push heroku main

4. Open the application in your web browser:

heroku open

### Google Cloud Platform

1. Create a Google Cloud Platform project:

gcloud projects create [PROJECT-ID]

2. Enable the Cloud Run API:

gcloud services enable run.googleapis.com

3. Build a container image:

gcloud builds submit --tag gcr.io/[PROJECT-ID]/pedidos-service

4. Deploy the container image:

gcloud run deploy --image gcr.io/[PROJECT-ID]/pedidos-service --platform managed --region us-central1

5. Open the application in your web browser:

gcloud run services describe --platform managed --region us-central1 --format "value(status.url)" pedidos-service
