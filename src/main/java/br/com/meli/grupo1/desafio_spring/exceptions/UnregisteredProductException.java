package br.com.meli.grupo1.desafio_spring.exceptions;

public class UnregisteredProductException extends RuntimeException{
    public UnregisteredProductException(String msg){
        super(msg);
    }
}
