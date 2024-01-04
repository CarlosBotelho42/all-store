package br.com.allstore.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record UpdateClientBalanceDTO(
        @CPF
        @NotBlank
        String document,

        @NotNull
        Float balance) {

}
