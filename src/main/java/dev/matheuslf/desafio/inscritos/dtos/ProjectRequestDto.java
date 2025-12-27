package dev.matheuslf.desafio.inscritos.dtos;
import java.time.LocalDate;


public record ProjectRequestDto (
        String nome,
        String description,
        LocalDate start_date,
        LocalDate end_date
){}
