package dev.matheuslf.desafio.inscritos.service;

import dev.matheuslf.desafio.inscritos.dtos.TaskRequestDto;
import dev.matheuslf.desafio.inscritos.dtos.TaskResponseDto;
import dev.matheuslf.desafio.inscritos.mapper.TaskMapper;
import dev.matheuslf.desafio.inscritos.model.ProjectEntity;
import dev.matheuslf.desafio.inscritos.model.TaskEntity;
import dev.matheuslf.desafio.inscritos.repository.ProjectRepository;
import dev.matheuslf.desafio.inscritos.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;
    private final TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, ProjectRepository projectRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
        this.taskMapper = taskMapper;
    }

    public TaskResponseDto createTask(TaskRequestDto requestDto) {
        ProjectEntity projetoExistente = projectRepository.findById(requestDto.project()).orElseThrow(() -> new RuntimeException("Projeto não encontrado!"));

        TaskEntity entity = taskMapper.toEntity(requestDto);
        entity.setProject(projetoExistente);
        taskRepository.saveAndFlush(entity);

        return taskMapper.toResponseDto(entity);
    }

    public TaskResponseDto findById(Long id){
        TaskEntity task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task não encontrada!"));
        return taskMapper.toResponseDto(task);
    }

    public List<TaskResponseDto> findAll(){
        List<TaskEntity> tasks = taskRepository.findAll();

        return tasks.stream()
                .map(taskMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public TaskResponseDto updateTask(Long id, TaskRequestDto dto) {
        TaskEntity taskExistente = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task não encontrada!"));

        taskMapper.updateEntityFromDto(dto, taskExistente);
        TaskEntity saved = taskRepository.save(taskExistente);

        return taskMapper.toResponseDto(saved);
    }

    public TaskResponseDto updateStatus(Long id, TaskRequestDto dto) {
        TaskEntity taskExistente = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task não encontrada!"));
        taskExistente.setStatus(dto.status());
        taskRepository.save(taskExistente);
        return taskMapper.toResponseDto(taskExistente);
    }

    public void deleteById(Long id){
        TaskResponseDto task = findById(id);
        if (task != null) {
            taskRepository.deleteById(id);
        }
    }
}
