package dev.matheuslf.desafio.inscritos.exceptions;

public class StatusNaoAlteradoException extends RuntimeException{
    public StatusNaoAlteradoException(Long id){
        super("Status da task de ID " + id +" Inválido");
    }
}
