package dev.matheuslf.desafio.inscritos.service;

import dev.matheuslf.desafio.inscritos.dtos.ProjectRequestDto;
import dev.matheuslf.desafio.inscritos.dtos.ProjectResponseDto;
import dev.matheuslf.desafio.inscritos.model.ProjectEntity;
import dev.matheuslf.desafio.inscritos.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
    public ProjectResponseDto createProject(ProjectRequestDto dtoRequest) {

        ProjectEntity entity = new ProjectEntity();
        entity.setName(dtoRequest.name());
        entity.setDescription(dtoRequest.description());
        entity.setStart_date(dtoRequest.start_date());
        entity.setEnd_date(dtoRequest.end_date());
        projectRepository.save(entity);

        return new ProjectResponseDto(
                entity.getId(),
                dtoRequest.name(),
                dtoRequest.description(),
                dtoRequest.start_date(),
                dtoRequest.end_date()
        );
    }
    public List<ProjectResponseDto> findAll(){
        return projectRepository.findAll()
                .stream()
                .map(user -> new ProjectResponseDto(
                        user.getId(),
                        user.getName(),
                        user.getDescription(),
                        user.getStart_date(),
                        user.getEnd_date()
                )).collect(Collectors.toList());
    }
    public ProjectResponseDto findOne(Long id){
        ProjectEntity entity = projectRepository.findById(id).orElseThrow(() -> new RuntimeException("Projeto não encontrado!"));
        return new ProjectResponseDto(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getStart_date(),
                entity.getEnd_date()
        );
    }
    public ProjectResponseDto updateProject(Long id, ProjectRequestDto dto) {
        ProjectEntity projetoExistente = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado!"));

        projetoExistente.setName(dto.name());
        projetoExistente.setDescription(dto.description());
        projetoExistente.setStart_date(dto.start_date());
        projetoExistente.setEnd_date(dto.end_date());

        ProjectEntity saved = projectRepository.save(projetoExistente);

        return new ProjectResponseDto(
                saved.getId(),
                saved.getName(),
                saved.getDescription(),
                saved.getStart_date(),
                saved.getEnd_date()
        );
    }
    public void deleteProject(Long id) {
        projectRepository.findById(id).orElseThrow(() -> new RuntimeException("Projeto não encontrado!"));
        projectRepository.deleteById(id);
    }
}
