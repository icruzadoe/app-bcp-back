package com.desafio.bcp.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Data
@Table("typechange")
public class TypeChange {
    @Id
    private Integer id;

    @Column("origin_currency")
    @JsonProperty("origin_currency")
    private String originCurrency;

    @Column("destination_currency")
    @JsonProperty("destination_currency")
    private String destinationCurrency;

    @Column("price")
    @JsonProperty("monto")
    private Double price;
}
