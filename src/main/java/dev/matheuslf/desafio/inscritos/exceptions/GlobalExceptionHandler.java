package dev.matheuslf.desafio.inscritos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProjetoNaoEncontradoException.class)
    public ResponseEntity<?> handleProjetoNaoEncontrado(ProjetoNaoEncontradoException exception){
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.NOT_FOUND.value());
        response.put("timestamp", LocalDateTime.now());
        response.put("message", exception.getMessage());
        response.put("tipo", "PROJETO_NAO_ENCONTRADO");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(DataInvalidaException.class)
    public ResponseEntity<?> handleDataInvalida(DataInvalidaException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("timestamp", LocalDateTime.now());
        response.put("message", ex.getMessage());
        response.put("tipo", "DATA_INVALIDA");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(TaskNaoEncontradaException.class)
    public ResponseEntity<?> handleTaskNaoEncontrado(TaskNaoEncontradaException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.NOT_FOUND.value());
        response.put("timestamp", LocalDateTime.now());
        response.put("message", ex.getMessage());
        response.put("tipo", "TASK_NAO_ENCONTRADA");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(StatusNaoAlteradoException.class)
    public ResponseEntity<?> handleStatusNaoAlterado(StatusNaoAlteradoException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.NOT_FOUND.value());
        response.put("timestamp", LocalDateTime.now());
        response.put("message", ex.getMessage());
        response.put("tipo", "STATUS_NAO_ALTERADO");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntimeException(RuntimeException ex){
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("timestamp", LocalDateTime.now());
        response.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

}
