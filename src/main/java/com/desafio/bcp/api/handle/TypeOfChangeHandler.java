package com.desafio.bcp.api.handle;

import com.desafio.bcp.api.entity.TypeChange;
import com.desafio.bcp.api.domain.TypeChangeCurrencyRequest;
import com.desafio.bcp.api.services.TypeOfChangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class TypeOfChangeHandler {

    private final TypeOfChangeService service;

    public Mono<ServerResponse> findAll(ServerRequest request){
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(service.findAll(), TypeChange.class);
    }

    public Mono<ServerResponse> calculateResult(ServerRequest request) {
        Mono<TypeChangeCurrencyRequest> currency = request.bodyToMono(TypeChangeCurrencyRequest.class);
        return currency.flatMap(p -> service.calculateResult(p))
                .flatMap(m -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(m)))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}
