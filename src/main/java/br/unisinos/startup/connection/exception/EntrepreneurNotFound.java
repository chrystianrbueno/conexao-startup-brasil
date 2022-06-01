package br.unisinos.startup.connection.exception;

public class EntrepreneurNotFound extends RuntimeException{

    public EntrepreneurNotFound(String id) {
        super("Entrepreneur with id " + id + " does not exist on repository");
    }
}