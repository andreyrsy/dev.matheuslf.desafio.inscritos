package dev.matheuslf.desafio.inscritos.controller;

import dev.matheuslf.desafio.inscritos.dtos.ProjectRequestDto;
import dev.matheuslf.desafio.inscritos.dtos.ProjectResponseDto;
import dev.matheuslf.desafio.inscritos.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping()
    public ResponseEntity<ProjectResponseDto> create(@RequestBody ProjectRequestDto dto){
        ProjectResponseDto response = projectService.createProject(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ProjectResponseDto>> listAll(){
        List<ProjectResponseDto> allUsers = projectService.findAll();
        return ResponseEntity.ok(allUsers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponseDto> findOne(@PathVariable Long id){
        ProjectResponseDto dto = projectService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectResponseDto> update(@PathVariable Long id, @RequestBody ProjectRequestDto dto){
        ProjectResponseDto dtoResponse = projectService.updateProject(id, dto);
        return ResponseEntity.ok().body(dtoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        projectService.deleteProject(id);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
}
