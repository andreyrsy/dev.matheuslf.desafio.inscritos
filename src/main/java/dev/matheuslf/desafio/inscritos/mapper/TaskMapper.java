package dev.matheuslf.desafio.inscritos.mapper;
import dev.matheuslf.desafio.inscritos.dtos.ProjectResponseDto;
import dev.matheuslf.desafio.inscritos.dtos.TaskRequestDto;
import dev.matheuslf.desafio.inscritos.dtos.TaskResponseDto;
import dev.matheuslf.desafio.inscritos.model.TaskEntity;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    private final ProjectMapper projectMapper;

    public TaskMapper(ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }

    public TaskEntity toEntity(TaskRequestDto dto) {
        TaskEntity entity = new TaskEntity();
        entity.setTitle(dto.title());
        entity.setDescription(dto.description());
        entity.setStatus(dto.status());
        entity.setPriority(dto.priority());
        entity.setDue_date(dto.due_date());
        return entity;
    }

    public TaskResponseDto toResponseDto(TaskEntity entity) {
        ProjectResponseDto projectDto = projectMapper.toResponseDto(entity.getProject());
        return new TaskResponseDto(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getStatus(),
                entity.getPriority(),
                entity.getDue_date(),
                projectDto
        );
    }

    public void updateEntityFromDto(TaskRequestDto dtoRequest, TaskEntity entity){
        entity.setTitle(dtoRequest.title());
        entity.setDescription(dtoRequest.description());
        entity.setStatus(dtoRequest.status());
        entity.setPriority(dtoRequest.priority());
        entity.setDue_date(dtoRequest.due_date());
    }
}
