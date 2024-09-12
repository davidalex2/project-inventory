# ORDER SERVICE

## Description
The Order Service is a microservice that handles order-related
operations, such as creating, updating, and deleting orders.

## Technologies
- *Programming Languages:* JAVA, SQL
- *Database Management:* Postgresql
- *API Frameworks:* Spring boot, Microservice
- *Version Control:* Git, GitHub

## Setup

1. Clone the repository :

        git clone https://github.com/your-username/order-service.git

2. Database Setup :

- Install Postgresql and create a database.
- Update the 'application.yml' file with your database configuration

3. Build and Run :

- Build the project using Maven :

         mvn clean install

- Run the application :

        java -jar target/order-0.0.1-SNAPSHOT.jar


4. And this project microservices needs to execute by step by step like:

        - service-registory
        - api-gateway
        - jwtLogin
        - order

5. Integration with Eureka Server and API Gateway:

- Ensure the Eureka Server and API Gateway is running.
- Update the 'application.yml' file with the Eureka Server URL and API Gateway URL.

6. To use end-point:
   http://localhost:8765/swagger-ui/
   Using swagger-ui can trigger the project end-point

7. To saw the server ports and details
   http://localhost:8761 (Eureka Server)

## Usage
- Endpoints:

  - GET /products: Get all products.
  - GET /products/{id}: Get a product by ID.
  - POST /products: Create a new product.
  - PUT /products/{id}: Update a product.
  - DELETE /products/{id}: Delete a product.

- Custom Queries with @Query:

  - Use @Query annotations in Spring Data JPA repositories to define custom queries.
  - Example :

            @Query(value = "SELECT * FROM Product", nativeQuery = true)
            List<Product> getAllProducts();

## Dependencies
- Java 8 SE
- Postgresql
- Maven project building tool
- Eureka Server
- API Gateway

## Conclusion

The Order Service project has successfully
integrated with Postgresql, yml files, pom.xml,
Eureka Server, and API Gateway. The use of @Query
annotations in Spring Data JPA has enabled efficient
custom queries. Overall, the project has achieved its
goals of providing a robust and scalable order service.