package br.com.meli.grupo1.desafio_spring.exceptions;

public class EmptyPurchaseException extends RuntimeException{
    public EmptyPurchaseException(String message) {
        super(message);
    }
}
