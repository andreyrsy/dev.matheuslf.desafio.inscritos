package dev.matheuslf.desafio.inscritos.dtos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;


public record ProjectRequestDto (
        @NotBlank(message = "O nome é obrigatório!")
        String name,

        String description,
        @NotEmpty(message = "A data de início é obrigatória!")

        LocalDate start_date,

        @NotEmpty(message = "A data final é obrigatória!")
        LocalDate end_date
){}
