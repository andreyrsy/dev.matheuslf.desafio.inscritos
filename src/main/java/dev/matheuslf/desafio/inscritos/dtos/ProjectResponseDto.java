package dev.matheuslf.desafio.inscritos.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectResponseDto{
    private Long id;
    private String nome;
    private String description;
    private LocalDate start_date;
    private LocalDate end_date;
}