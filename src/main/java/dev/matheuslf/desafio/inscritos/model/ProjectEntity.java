package dev.matheuslf.desafio.inscritos.model;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_project")
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;
}