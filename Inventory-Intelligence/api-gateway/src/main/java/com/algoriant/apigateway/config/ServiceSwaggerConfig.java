package com.algoriant.apigateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Primary
public class ServiceSwaggerConfig implements SwaggerResourcesProvider {

    public static final String API_URI = "/v2/api-docs";


    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        resources.add(swaggerResource("USER-SERVICE-WITH-LOGIN","/user-service"+API_URI));
        resources.add(swaggerResource("PRODUCT-SERVICE","/product-service"+API_URI));
        resources.add(swaggerResource("INVENTORY-SERVICE","/inventory-service"+API_URI));
        resources.add(swaggerResource("ORDER-SERVICE","/order-service"+API_URI));
        resources.add(swaggerResource("SITE-SERVICE","/site-service"+API_URI));
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location) {
        SwaggerResource resource = new SwaggerResource();
        resource.setName(name);
        resource.setLocation(location);
        resource.setSwaggerVersion("2.0");
        return resource;
    }

}
