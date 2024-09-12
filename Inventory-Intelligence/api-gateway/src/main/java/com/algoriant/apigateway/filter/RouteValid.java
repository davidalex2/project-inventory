package com.algoriant.apigateway.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Component
public class RouteValid {
    public static final List<String> openApi = new ArrayList<>(Arrays.asList("/auth/login","auth/validateToken","/eureka"));

    public Predicate<ServerHttpRequest> isSecured = serverHttpRequest -> openApi.stream()
            .noneMatch(uri->serverHttpRequest.getURI().getPath().contains(uri));


}
