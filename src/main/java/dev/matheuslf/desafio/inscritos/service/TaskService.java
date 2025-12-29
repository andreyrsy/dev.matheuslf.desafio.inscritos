package dev.matheuslf.desafio.inscritos.service;

import dev.matheuslf.desafio.inscritos.dtos.ProjectResponseDto;
import dev.matheuslf.desafio.inscritos.dtos.TaskRequestDto;
import dev.matheuslf.desafio.inscritos.dtos.TaskResponseDto;
import dev.matheuslf.desafio.inscritos.model.ProjectEntity;
import dev.matheuslf.desafio.inscritos.model.TaskEntity;
import dev.matheuslf.desafio.inscritos.repository.ProjectRepository;
import dev.matheuslf.desafio.inscritos.repository.TaskRepository;
import org.springframework.stereotype.Service;


@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;

    public TaskService(TaskRepository taskRepository, ProjectRepository projectRepository) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
    }

    public TaskResponseDto createTask(TaskRequestDto requestDto) {
        ProjectEntity projetoExistente = projectRepository.findById(requestDto.project()).orElseThrow(() -> new RuntimeException("Projeto não encontrado!"));
        TaskEntity entity = new TaskEntity();

        entity.setTitle(requestDto.title());
        entity.setDescription(requestDto.description());
        entity.setStatus(requestDto.status());
        entity.setPriority(requestDto.priority());
        entity.setDue_date(requestDto.due_date());

        entity.setProject(projetoExistente);
        taskRepository.saveAndFlush(entity);

        ProjectResponseDto projectToDto = new ProjectResponseDto(
                projetoExistente.getId(),
                projetoExistente.getName(),
                projetoExistente.getDescription(),
                projetoExistente.getStart_date(),
                projetoExistente.getEnd_date()
        );

        return new TaskResponseDto(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getStatus(),
                entity.getPriority(),
                entity.getDue_date(),
                projectToDto
        );
    }

    public TaskEntity findById(Long id){
        return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task não encontrada!"));
    }
}
