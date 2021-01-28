package com.desafio.bcp.api.services;

import com.desafio.bcp.api.domain.TypeChangeCurrencyRequest;
import com.desafio.bcp.api.domain.TypeChangeCurrencyResponse;
import com.desafio.bcp.api.entity.TypeChange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TypeOfChangeService {
    Flux<TypeChange> findAll();

    Mono<TypeChangeCurrencyResponse> calculateResult(TypeChangeCurrencyRequest request);

}
