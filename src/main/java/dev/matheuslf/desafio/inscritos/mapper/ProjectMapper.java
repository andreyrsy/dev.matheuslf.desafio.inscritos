package dev.matheuslf.desafio.inscritos.mapper;

import dev.matheuslf.desafio.inscritos.dtos.ProjectRequestDto;
import dev.matheuslf.desafio.inscritos.dtos.ProjectResponseDto;
import dev.matheuslf.desafio.inscritos.model.ProjectEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    ProjectEntity toEntity(ProjectRequestDto dtoRequest);

    ProjectResponseDto toResponseDto(ProjectEntity entity);

    void updateEntity(ProjectRequestDto dto, @MappingTarget ProjectEntity entity);
}
