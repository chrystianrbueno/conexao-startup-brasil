package br.unisinos.startup.connection.exception;

public class InvestorNotFoundException extends RuntimeException{

    public InvestorNotFoundException(String id) {
        super("Investor with id " + id + " does not exist on repository");
    }
}