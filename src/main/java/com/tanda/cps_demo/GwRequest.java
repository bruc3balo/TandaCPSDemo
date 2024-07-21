package com.tanda.cps_demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class GwRequest {

    @JsonProperty("id")
    @NotBlank(message = "id required")
    private String transactionId;

    @NotNull(message = "amount required")
    private BigDecimal amount;

    @NotNull(message = "mobileNumber required")
    private Long mobileNumber;

    public GwRequest() {

    }
}
