package dev.matheuslf.desafio.inscritos.exceptions;

public class DataInvalidaException extends RuntimeException{
    public DataInvalidaException(String mensagem) {
        super(mensagem);
    }

    public DataInvalidaException(String campo, String valor) {
        super("Data inválida para o campo '" + campo + "': " + valor);
    }
}
