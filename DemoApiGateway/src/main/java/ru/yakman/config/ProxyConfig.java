/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.yakman.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

/**
 *
 * @author Test
 */
@Configuration
public class ProxyConfig {

    @Bean
    RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("request_route",
                        (PredicateSpec route) -> {
                            return route.path("/demo-request/**")
                                    .and()
                                    .method(HttpMethod.GET)
                                    .filters((filter) -> {
                                        return filter.stripPrefix(1);
                                    })
                                    .uri("lb://demo-request");
                        })
                .route("data_route",
                        route -> route.path("/demo-data/**")
                                .and()
                                .method(HttpMethod.GET)
                                .filters(filter -> filter.stripPrefix(1))
                                .uri("lb://demo-data"))
                .build();
    }

}
