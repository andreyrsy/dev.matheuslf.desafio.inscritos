package dev.matheuslf.desafio.inscritos.service;

import dev.matheuslf.desafio.inscritos.dtos.ProjectRequestDto;
import dev.matheuslf.desafio.inscritos.dtos.ProjectResponseDto;
import dev.matheuslf.desafio.inscritos.model.ProjectEntity;
import dev.matheuslf.desafio.inscritos.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
    public ProjectEntity createProject(ProjectEntity projectEntity) {
        return projectRepository.save(projectEntity);
    }
    public List<ProjectEntity> findAll(){
        return projectRepository.findAll();
    }
    public ProjectEntity findOne(Long id){
        return projectRepository.findById(id).orElseThrow(() -> new RuntimeException("Projeto não encontrado!"));
    }
    public ProjectResponseDto updateProject(Long id, ProjectRequestDto dto) {
        ProjectEntity projetoExistente = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado!"));

        projetoExistente.setNome(dto.nome());
        projetoExistente.setDescription(dto.description());
        projetoExistente.setStartDate(dto.start_date());
        projetoExistente.setEndDate(dto.end_date());

        ProjectEntity saved = projectRepository.save(projetoExistente);

        ProjectResponseDto responseDto = new ProjectResponseDto();
        responseDto.setId(saved.getId());
        responseDto.setNome(saved.getNome());
        responseDto.setDescription(saved.getDescription());
        responseDto.setStart_date(saved.getStartDate());
        responseDto.setEnd_date(saved.getEndDate());

        return responseDto;
    }
    public void deleteProject(Long id) {
        ProjectEntity projetoEncontrado = findOne(id);
        if(projetoEncontrado == null){
            throw new RuntimeException("Projeto não encontrado!");
        }
        projectRepository.deleteById(id);
    }
}
