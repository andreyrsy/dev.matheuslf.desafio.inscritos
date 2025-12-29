package dev.matheuslf.desafio.inscritos.mapper;

import dev.matheuslf.desafio.inscritos.dtos.ProjectRequestDto;
import dev.matheuslf.desafio.inscritos.dtos.ProjectResponseDto;
import dev.matheuslf.desafio.inscritos.model.ProjectEntity;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {
    public ProjectEntity toEntity(ProjectRequestDto dtoRequest){
        ProjectEntity project = new ProjectEntity();
        project.setName(dtoRequest.name());
        project.setDescription(dtoRequest.description());
        project.setStart_date(dtoRequest.start_date());
        project.setEnd_date(dtoRequest.end_date());
        return project;
    }

    public ProjectResponseDto toResponseDto(ProjectEntity entity){
        return new ProjectResponseDto(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getStart_date(),
                entity.getEnd_date()
        );
    }

    public void updateEntityFromDto(ProjectRequestDto dtoRequest, ProjectEntity entity){
        entity.setName(dtoRequest.name());
        entity.setDescription(dtoRequest.description());
        entity.setStart_date(dtoRequest.start_date());
        entity.setEnd_date(dtoRequest.end_date());
    }
}
