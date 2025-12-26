package dev.matheuslf.desafio.inscritos.controller;

import dev.matheuslf.desafio.inscritos.model.ProjectEntity;
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
    public ResponseEntity<ProjectEntity> create(@RequestBody ProjectEntity projectEntity){
        projectService.createProject(projectEntity);
        return ResponseEntity.ok(projectEntity);
    }

    @GetMapping
    public ResponseEntity<List<ProjectEntity>> listAll(){
        List<ProjectEntity> all = projectService.findAll();
        return ResponseEntity.ok(all);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectEntity> update(@PathVariable Long id, @RequestBody ProjectEntity projectEntity){
        projectService.updateProject(id, projectEntity);
        return ResponseEntity.ok(projectEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        projectService.deleteProject(id);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
}
