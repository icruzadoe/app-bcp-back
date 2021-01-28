package com.desafio.bcp.api.configuration;

import com.desafio.bcp.api.handle.TypeOfChangeHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterFunctionConfig {

    @Bean
    public RouterFunction <ServerResponse> routes(TypeOfChangeHandler handler){
        return RouterFunctions.route(RequestPredicates.GET("/api/money/type"),handler::findAll)
                .andRoute(RequestPredicates.POST("/api/money/calculate"),handler::calculateResult);

    }
}
