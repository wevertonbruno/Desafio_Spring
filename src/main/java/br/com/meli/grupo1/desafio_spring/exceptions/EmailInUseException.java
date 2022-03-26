package br.com.meli.grupo1.desafio_spring.exceptions;


/*
* Exeption para email ja cadastrado
* @author Ederson Rodrigues
* */
public class EmailInUseException extends RuntimeException{
    public EmailInUseException(String message) {
        super(message);
    }
}
