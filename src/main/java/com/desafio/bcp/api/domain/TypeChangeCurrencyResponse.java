package com.desafio.bcp.api.domain;

import com.desafio.bcp.api.entity.TypeChange;
import lombok.Data;

@Data
public class TypeChangeCurrencyResponse {
    private TypeChange type;
    private Double amount;
    private double amountTypeChange;


}
