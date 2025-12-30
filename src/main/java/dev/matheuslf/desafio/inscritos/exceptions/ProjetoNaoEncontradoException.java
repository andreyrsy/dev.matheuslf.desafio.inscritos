package dev.matheuslf.desafio.inscritos.exceptions;

public class ProjetoNaoEncontradoException extends RuntimeException{
    public ProjetoNaoEncontradoException(Long id){
        super("Projeto com o ID " + id + " não encontrado");
    }
}
