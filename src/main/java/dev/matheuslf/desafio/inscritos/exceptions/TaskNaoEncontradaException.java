package dev.matheuslf.desafio.inscritos.exceptions;

public class TaskNaoEncontradaException extends RuntimeException{
    public TaskNaoEncontradaException(Long id){
        super("Task com o ID " + id + " não encontrada");
    }
}
