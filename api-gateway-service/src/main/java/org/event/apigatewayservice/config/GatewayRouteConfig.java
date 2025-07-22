package org.event.apigatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRouteConfig {
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("validation-route", r -> r.path("/validation/**")
//                        .filters(f -> f.stripPrefix(1))
//                        .uri("lb://validation-service"))
//
//                .route("briefing-route", r -> r.path("/briefing/**")
//                        .filters(f -> f.stripPrefix(1))
//                        .uri("lb://briefing-service"))
//
//                .route("skill-route", r -> r.path("/skill/**")
//                        .filters(f -> f.stripPrefix(1))
//                        .uri("lb://skill-service"))
//
//                .build();
//    }
}
