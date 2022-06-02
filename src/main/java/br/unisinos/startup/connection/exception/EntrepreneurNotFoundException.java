package br.unisinos.startup.connection.exception;

public class EntrepreneurNotFoundException extends RuntimeException{

    public EntrepreneurNotFoundException(String id) {
        super("Entrepreneur with id " + id + " does not exist on repository");
    }
}