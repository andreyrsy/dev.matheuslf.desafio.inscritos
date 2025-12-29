package dev.matheuslf.desafio.inscritos.service;

import dev.matheuslf.desafio.inscritos.dtos.ProjectRequestDto;
import dev.matheuslf.desafio.inscritos.dtos.ProjectResponseDto;
import dev.matheuslf.desafio.inscritos.mapper.ProjectMapper;
import dev.matheuslf.desafio.inscritos.model.ProjectEntity;
import dev.matheuslf.desafio.inscritos.repository.ProjectRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectService(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }
    public ProjectResponseDto createProject(@Valid ProjectRequestDto dtoRequest) {
        ProjectEntity toEntity = projectMapper.toEntity(dtoRequest);
        projectRepository.save(toEntity);

        return projectMapper.toResponseDto(toEntity);
    }
    public List<ProjectResponseDto> findAll(){
        return projectRepository.findAll()
                .stream()
                .map(projectMapper::toResponseDto)
                .collect(Collectors.toList());
    }
    public ProjectResponseDto findOne(@Valid Long id){
        ProjectEntity entity = projectRepository.findById(id).orElseThrow(() -> new RuntimeException("Projeto não encontrado!"));
        return projectMapper.toResponseDto(entity);
    }
    public ProjectResponseDto updateProject(@Valid Long id, @Valid ProjectRequestDto dto) {
        ProjectEntity projetoExistente = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado!"));

        projectMapper.updateEntityFromDto(dto, projetoExistente);
        ProjectEntity saved = projectRepository.save(projetoExistente);
        return projectMapper.toResponseDto(saved);
    }
    public void deleteProject(@Valid Long id) {
        projectRepository.findById(id).orElseThrow(() -> new RuntimeException("Projeto não encontrado!"));
        projectRepository.deleteById(id);
    }
}
