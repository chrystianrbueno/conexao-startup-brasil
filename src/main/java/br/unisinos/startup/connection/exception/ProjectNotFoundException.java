package br.unisinos.startup.connection.exception;

public class ProjectNotFoundException extends RuntimeException{

    public ProjectNotFoundException(String id) {
        super("Project with id " + id + " does not exist on repository");
    }
}