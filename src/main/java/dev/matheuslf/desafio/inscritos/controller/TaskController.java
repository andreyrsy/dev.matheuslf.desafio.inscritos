package dev.matheuslf.desafio.inscritos.controller;

import dev.matheuslf.desafio.inscritos.dtos.TaskRequestDto;
import dev.matheuslf.desafio.inscritos.dtos.TaskResponseDto;
import dev.matheuslf.desafio.inscritos.model.TaskEntity;
import dev.matheuslf.desafio.inscritos.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskResponseDto> create(@RequestBody TaskRequestDto taskRequestDto){
        TaskResponseDto responseDto = taskService.createTask(taskRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskEntity> findById(@PathVariable Long id){
        TaskEntity taskEntity = taskService.findById(id);
        return ResponseEntity.ok(taskEntity);
    }
}
