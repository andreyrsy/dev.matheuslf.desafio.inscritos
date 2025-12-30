package dev.matheuslf.desafio.inscritos.dtos;

import dev.matheuslf.desafio.inscritos.model.enums.PriorityEnum;
import dev.matheuslf.desafio.inscritos.model.enums.StatusEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record TaskRequestDto(
        @NotEmpty(message = "O título é obrigatório!")
        @Size(min = 5, max = 150, message = "Titulo deve ter entre 5 e 150 caracteres.")
        String title,

        @NotEmpty(message = "Descrição não pode ser vazia!")
        String description,

        @NotEmpty(message = "A Task deve ter um Status!")
        @Enumerated(EnumType.STRING)
        StatusEnum status,

        @NotEmpty(message = ("A Task deve ter uma prioridade!"))
        @Enumerated(EnumType.STRING)
        PriorityEnum priority,

        @NotEmpty(message = "A Task deve ter data limite!")
        LocalDate due_date,

        @NotBlank(message = "A Task deve ter um projeto atribuído!")
        Long project
) {
}
