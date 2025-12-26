package dev.matheuslf.desafio.inscritos.service;

import dev.matheuslf.desafio.inscritos.model.ProjectEntity;
import dev.matheuslf.desafio.inscritos.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public ProjectEntity updateProject(Long id, ProjectEntity projectEntity) {
        ProjectEntity projetoEncontrado = findOne(id);
        if(projetoEncontrado == null){
            throw new RuntimeException("Projeto não encontrado!");
        }

        projetoEncontrado.setNome(projectEntity.getNome());
        projetoEncontrado.setDescription(projectEntity.getDescription());
        projetoEncontrado.setStartDate(projectEntity.getStartDate());
        projetoEncontrado.setEndDate(projectEntity.getEndDate());

        return projectRepository.save(projectEntity);
    }
    public void deleteProject(Long id) {
        ProjectEntity projetoEncontrado = findOne(id);
        if(projetoEncontrado == null){
            throw new RuntimeException("Projeto não encontrado!");
        }
        projectRepository.deleteById(id);
    }
}
