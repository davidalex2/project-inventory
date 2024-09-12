# Inventory Intelligence

## Overview
    The Inventory Intelligence Backend is a core component of the Inventory Intelligence Project, responsible for handling data collection, processing, and integration tasks to support inventory management analytics.

## Features
- **Data Collection:** Retrieve inventory data from various sources such as sales records, purchase orders, and inventory counts.
- **Data Cleaning and Transformation:** Cleanse and transform raw data into a standardized format suitable for analysis.
- **Database Management:** Design and optimize databases to store inventory data efficiently, ensuring scalability and performance.
- **API Development:** Create RESTful APIs for accessing and retrieving inventory data, facilitating integration with frontend applications and third-party systems.
- **Integration:** Integrate backend systems with existing ERP (Enterprise Resource Planning) or inventory management software to enable data exchange and synchronization.
- **Security and Compliance:** Ensure data security and compliance with relevant regulations by implementing appropriate security measures and access controls

## Technologies
- **Programming Languages:** JAVA, SQL
- **Database Management:** PostgreSQL
- **API Frameworks:** Spring boot, Microservice
- **Version Control:** Git, GitHub

## Building the project
You will need:

- Java JDK 8 or higher
- Maven 3.1.1 or higher
- Git

Clone the project

Create database in the name as - 'inventory_db'

To create tables execute the file name called db.sh
        -db.sh

Append this to each microservice end of application.yml based on using database, username, and password

        ---
        spring:
          datasource:
            url: jdbc:postgresql://<your_mysql_host_or_ip>/bootexample
            username: <your_mysql_username>
            password: <your_mysql_password>
            
For execution need to build each service after build need to run each service jar file by using the run.sh file 

        -run.sh
 
 Once the application runs you should see something like this

        2017-08-29 17:31:23.091  INFO 19387 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8090 (http)
        2017-08-29 17:31:23.097  INFO 19387 --- [           main] com.khoubyari.example.Application        : Started Application in 22.285 seconds (JVM running for 23.032)

To use end-point:
        http://localhost:8765/swagger-ui/
Using swagger-ui can trigger the project end-point

To saw the server ports and details
         http://localhost:8761 (Eureka Server)
         
## Running the project with MySQL
This project uses an in-memory database so that you don't have to install a database in order to run it. However, converting it to run with another relational database such as MySQL or PostgreSQL is very easy. Since the project uses Spring Data and the Repository pattern, it's even fairly easy to back the same service with MongoDB.

Here is what you would do to back to the each microservices with MySQL, for example:

In pom.xml add:
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
Append this to the end of application.yml:
---
        spring:
            datasource:
                url: jdbc:mysql://<your_mysql_host_or_ip>/bootexample
                username: <your_mysql_username>
                password: <your_mysql_password>


## Timeline

- **Phase 1: Requirements Gathering and Planning (Month 1)**
  - Define project scope and objectives
  - Gather requirements for data sources and integration points
  - Plan database schema and API design

- **Phase 2: Data Pipeline Development (Month 2-3)**
  - Build data collection pipelines for retrieving inventory data
  - Implement data cleaning and transformation processes
  - Design and deploy databases for storing inventory data

- **Phase 3: API Development (Month 4-5)**
  - Develop RESTful APIs for accessing inventory data
  - Implement authentication and authorization mechanisms
  - Test API endpoints for functionality and performance
  
- **Phase 7: Documentation and Training (Month 6)**
  - Document backend architecture, APIs, and data flows
  - Provide training to end-users 
  - Prepare deployment and maintenance guides

## Key Success Metrics

- Data retrieval and processing time
- API response time and throughput
- System uptime and reliability
- Compliance with data security and privacy regulations

## Conclusion

The Inventory Intelligence Backend Project plays a critical role in supporting inventory management analytics by developing robust backend systems. By ensuring efficient data collection, storage, and integration, the project aims to enhance operational efficiency and enable data-driven decision-making for inventory management processes.

