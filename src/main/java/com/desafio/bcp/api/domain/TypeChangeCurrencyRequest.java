package com.desafio.bcp.api.domain;

import com.desafio.bcp.api.entity.TypeChange;
import lombok.Data;

@Data
public class TypeChangeCurrencyRequest {
    private TypeChange infoChange;
    private Double amount;

}
