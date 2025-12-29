package dev.matheuslf.desafio.inscritos.dtos;

import dev.matheuslf.desafio.inscritos.model.enums.PriorityEnum;
import dev.matheuslf.desafio.inscritos.model.enums.StatusEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

public record TaskRequestDto(
        @NotEmpty
        String title,

        @NotEmpty
        String description,

        @NotEmpty
        @Enumerated(EnumType.STRING)
        StatusEnum status,

        @NotEmpty
        @Enumerated(EnumType.STRING)

        @NotEmpty
        PriorityEnum priority,

        @NotEmpty
        LocalDate due_date,

        @NotBlank
        Long project
) {
}
