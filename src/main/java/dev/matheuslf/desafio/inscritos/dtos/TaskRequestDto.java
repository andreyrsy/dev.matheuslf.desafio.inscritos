package dev.matheuslf.desafio.inscritos.dtos;

import dev.matheuslf.desafio.inscritos.model.enums.PriorityEnum;
import dev.matheuslf.desafio.inscritos.model.enums.StatusEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;

public record TaskRequestDto(
        String title,
        String description,
        @Enumerated(EnumType.STRING)
        StatusEnum status,
        @Enumerated(EnumType.STRING)
        PriorityEnum priority,
        LocalDate due_date,
        Long project
) {
}
