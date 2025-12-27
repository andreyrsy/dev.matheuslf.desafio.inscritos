package dev.matheuslf.desafio.inscritos.dtos;
import java.time.LocalDate;

public record ProjectResponseDto(
    Long id,
    String nome,
    String description,
    LocalDate start_date,
    LocalDate end_date
){}