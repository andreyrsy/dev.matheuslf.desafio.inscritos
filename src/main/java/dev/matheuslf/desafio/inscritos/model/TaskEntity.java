package dev.matheuslf.desafio.inscritos.model;
import dev.matheuslf.desafio.inscritos.model.enums.PriorityEnum;
import dev.matheuslf.desafio.inscritos.model.enums.StatusEnum;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_task")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @Enumerated(EnumType.STRING)
    private PriorityEnum priority;

    private LocalDate dueDate;

    @ManyToOne
    private ProjectEntity project;
}
