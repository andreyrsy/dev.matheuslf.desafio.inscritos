package dev.matheuslf.desafio.inscritos.controller;

import dev.matheuslf.desafio.inscritos.dtos.TaskRequestDto;
import dev.matheuslf.desafio.inscritos.dtos.TaskResponseDto;
import dev.matheuslf.desafio.inscritos.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskResponseDto> create(@RequestBody TaskRequestDto dto){
        TaskResponseDto responseDto = taskService.createTask(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping()
    public ResponseEntity<List<TaskResponseDto>> findAll(){
        List<TaskResponseDto> allTasks = taskService.findAll();
        return ResponseEntity.ok(allTasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDto> findById(@PathVariable Long id){
        TaskResponseDto dto = taskService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDto> updateTask(@RequestBody TaskRequestDto dto, @PathVariable Long id){
        TaskResponseDto updatedTaskDto = taskService.updateTask(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedTaskDto);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<TaskResponseDto> updateStatus(@PathVariable Long id, @RequestBody TaskRequestDto status){
        TaskResponseDto updated = taskService.updateStatus(id, status);
        return ResponseEntity.accepted().body(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
