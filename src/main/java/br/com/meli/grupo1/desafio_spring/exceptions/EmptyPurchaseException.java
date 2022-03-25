package br.com.meli.grupo1.desafio_spring.exceptions;


/*
* Exeption para compras invalidas (Sem produtos no payload)
* @author Weverton Bruno
* */
public class EmptyPurchaseException extends RuntimeException{
    public EmptyPurchaseException(String message) {
        super(message);
    }
}
