package dev.matheuslf.desafio.inscritos.dtos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;


public record ProjectRequestDto (
        @NotBlank(message = "O nome é obrigatório!")
        @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres.")
        String name,

        String description,
        @NotEmpty(message = "A data de início é obrigatória!")

        LocalDate start_date,

        @NotEmpty(message = "A data final é obrigatória!")
        LocalDate end_date
){}
