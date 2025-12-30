package dev.matheuslf.desafio.inscritos.dtos;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;


public record ProjectRequestDto (
        @NotBlank
        String name,

        String description,

        @NotEmpty
        LocalDate start_date,

        LocalDate end_date
){}
