package dev.matheuslf.desafio.inscritos.mapper;

import dev.matheuslf.desafio.inscritos.dtos.TaskRequestDto;
import dev.matheuslf.desafio.inscritos.dtos.TaskResponseDto;
import dev.matheuslf.desafio.inscritos.model.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {ProjectMapper.class})
public interface TaskMapper {
    @Mapping(target = "project", ignore = true)
    TaskEntity toEntity(TaskRequestDto dtoRequest);
    TaskResponseDto toResponseDto(TaskEntity entity);
    @Mapping(target = "project", ignore = true)
    void updateEntityFromDto(TaskRequestDto dtoRequest, @MappingTarget TaskEntity entity);
}
