package com.desafio.bcp.api.repository;

import com.desafio.bcp.api.entity.TypeChange;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TypeOfChangeRepository extends R2dbcRepository<TypeChange, Integer> {

    @Query("select distinct(destination_currency) from typechange")
    Flux<TypeChange> findAllTypeAmount();

    @Query("SELECT * FROM typechange WHERE origin_currency = :originCurrency AND destination_currency = :destinationCurrency")
    Mono<TypeChange> calculateResult(String originCurrency, String destinationCurrency);




}
