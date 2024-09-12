package com.algoriant.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.google.common.net.HttpHeaders.AUTHORIZATION;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    static final String AUTHORIZATION = "Authorization";

    @Bean
    public Docket getApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfo("ims api","inventory management System","1.0",
                        "www.algoriant.com", new Contact("algoriant",
                        "https://algoriant.com/","info@algoriant.com"),"closed source",
                        "https://algoriant.com/about-us.html",Collections.emptyList()))
                .securityContexts(Collections.singletonList(securityContext()))
                .securitySchemes(Collections.singletonList(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.algoriant.apigateway"))
                .paths(PathSelectors.any())
                .build()
                ;
    }

    private ApiKey apiKey() {
        return new ApiKey(AUTHORIZATION, AUTHORIZATION, "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Collections.singletonList(new SecurityReference(AUTHORIZATION, authorizationScopes));
    }
}
