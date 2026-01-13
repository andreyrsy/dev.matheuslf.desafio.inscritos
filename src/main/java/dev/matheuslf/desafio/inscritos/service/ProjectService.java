package dev.matheuslf.desafio.inscritos.service;

import dev.matheuslf.desafio.inscritos.dtos.ProjectRequestDto;
import dev.matheuslf.desafio.inscritos.dtos.ProjectResponseDto;
import dev.matheuslf.desafio.inscritos.exceptions.DataInvalidaException;
import dev.matheuslf.desafio.inscritos.exceptions.ProjetoNaoEncontradoException;
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
        try {
            if(!dtoRequest.start_date().isBefore(dtoRequest.end_date())){
                throw new DataInvalidaException("Data invalida!");
            }
            ProjectEntity toEntity = projectMapper.toEntity(dtoRequest);
            projectRepository.save(toEntity);
            return projectMapper.toResponseDto(toEntity);
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public List<ProjectResponseDto> findAll(){
        return projectRepository.findAll()
                .stream()
                .map(projectMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public ProjectResponseDto findById(@Valid Long id){
        try{
            ProjectEntity entity = projectRepository.findById(id).orElseThrow(() -> new RuntimeException("Projeto não encontrado!"));
            return projectMapper.toResponseDto(entity);
        }catch(Exception ex){
            throw new ProjetoNaoEncontradoException(id);
        }
    }

    public ProjectResponseDto updateProject(@Valid Long id, @Valid ProjectRequestDto dto) {
        ProjectEntity projetoExistente = projectRepository.findById(id)
                .orElseThrow(() -> new ProjetoNaoEncontradoException(id));

        projectMapper.updateEntity(dto, projetoExistente);

        if(!dto.start_date().isBefore(dto.end_date())){
            throw new DataInvalidaException("Data invalida!");
        }

        ProjectEntity saved = projectRepository.save(projetoExistente);
        return projectMapper.toResponseDto(saved);
    }

    public void deleteProject(@Valid Long id) {
        try{
            projectRepository.deleteById(id);
        }catch(Exception ex){
            throw new ProjetoNaoEncontradoException(id);
        }
    }
}
