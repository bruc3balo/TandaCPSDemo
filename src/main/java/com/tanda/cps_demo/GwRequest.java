package com.tanda.cps_demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class GwRequest {

    @JsonProperty("id")
    private String transactionId;

    private BigDecimal amount;

    private Long mobileNumber;

    public GwRequest() {

    }
}
