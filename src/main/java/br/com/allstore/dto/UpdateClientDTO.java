package br.com.allstore.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record UpdateClientDTO(
        @NotNull
        Long id,

        @NotBlank
        String name,

        @CPF
        @NotBlank
        String document
) {
}
