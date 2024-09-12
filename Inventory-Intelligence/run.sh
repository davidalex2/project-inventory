#!/bin/bash


gnome-terminal --tab --title="api-gateway" --command="bash -c 'cd ./api-gateway && mvn clean install -DskipTests && java -jar target/*.jar; exec bash'"

gnome-terminal --tab --title="service-registry" --command="bash -c 'cd ./service-registry && mvn clean install -DskipTests && java -jar target/*.jar; exec bash'"

gnome-terminal --tab --title="userDetail" --command="bash -c 'cd ./userDetail && mvn clean install -DskipTests && java -jar target/*.jar; exec bash'"

gnome-terminal --tab --title="product" --command="bash -c 'cd ./product && mvn clean install -DskipTests && java -jar target/*.jar; exec bash'"

gnome-terminal --tab --title="inventory" --command="bash -c 'cd ./inventory && mvn clean install -DskipTests && java -jar target/*.jar; exec bash'"

gnome-terminal --tab --title="order" --command="bash -c 'cd ./order && mvn clean install -DskipTests && java -jar target/*.jar; exec bash'"

gnome-terminal --tab --title="site-service" --command="bash -c 'cd ./site-service && mvn clean install -DskipTests && java -jar target/*.jar; exec bash'"

# Add more commands as needed for additional microservices
# gnome-terminal --tab --title="Microservice 3" -- bash -c "compile_and_run 'Microservice 3' '/path/to/microservice3'"


