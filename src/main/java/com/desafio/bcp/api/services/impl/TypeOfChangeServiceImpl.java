package com.desafio.bcp.api.services.impl;

import com.desafio.bcp.api.domain.TypeChangeCurrencyRequest;
import com.desafio.bcp.api.domain.TypeChangeCurrencyResponse;
import com.desafio.bcp.api.entity.TypeChange;
import com.desafio.bcp.api.repository.TypeOfChangeRepository;
import com.desafio.bcp.api.services.TypeOfChangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class TypeOfChangeServiceImpl implements TypeOfChangeService {

    private final TypeOfChangeRepository typeOfChangeRepository;
    @Override
    public Flux<TypeChange> findAll() {
        return typeOfChangeRepository.findAll();
    }

    @Override
    public Mono<TypeChangeCurrencyResponse> calculateResult(TypeChangeCurrencyRequest request) {
        return typeOfChangeRepository.calculateResult(request.getInfoChange().getOriginCurrency(),request.getInfoChange().getDestinationCurrency())
                .flatMap(p->{
                    TypeChangeCurrencyResponse response = new TypeChangeCurrencyResponse();
                    response.setType(p);
                    response.setAmount(request.getAmount());
                    response.setAmountTypeChange(request.getAmount()*p.getPrice());
                    return Mono.just(response); });
    }


}
