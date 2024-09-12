package com.algoriant.apigateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component

public class Authfilter  extends AbstractGatewayFilterFactory<Authfilter.Config> {

    private static final String URL ="http://localhost:8086/auth/validateToken?token=";
    @Autowired
    private RouteValid valid;

    @Autowired
    private RestTemplate template = new RestTemplate();

    public Authfilter() {
        super(Config.class);
    }


    @Override
    public GatewayFilter apply(Config config) {
        return (((exchange, chain) -> {
            if (valid.isSecured.test(exchange.getRequest())) {
                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    throw new RuntimeException("missing header");
                }
                String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                if (authHeader != null && authHeader.startsWith("Bearer ")) {
                    authHeader = authHeader.substring(7);
                }
                String hell = null;
                try {
                    HttpHeaders headers = new HttpHeaders();
                    headers.add("Authorization","Bearer "+authHeader);
                    HttpEntity<?> entity = new HttpEntity<>(headers);
                    ResponseEntity<String> response = template.exchange(URL+authHeader, HttpMethod.GET, entity, String.class);
                } catch (Exception ex) {
                    throw new RuntimeException("unauthorized access ", ex);
                }
            }
            return chain.filter(exchange);
        }));
    }



    public static class Config{

    }

}