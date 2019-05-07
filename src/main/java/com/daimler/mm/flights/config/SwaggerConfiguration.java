package com.daimler.mm.flights.config;

import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    private String applicationName;
    private String applicationDescription;

    @Autowired
    public SwaggerConfiguration(@Value("${spring.application.name:Api Documentation}") String applicationName,
                                     @Value("${spring.application.description:Api Documentation}") String applicationDescription) {
        this.applicationName = applicationName;
        this.applicationDescription = applicationDescription;
    }

    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.daimler.mm.flights.controller"))
                .paths(Predicates.not(PathSelectors.regex("/error")))
                .build();
    }
}
