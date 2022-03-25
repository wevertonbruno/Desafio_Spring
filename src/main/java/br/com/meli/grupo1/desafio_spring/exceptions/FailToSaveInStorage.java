package br.com.meli.grupo1.desafio_spring.exceptions;

public class FailToSaveInStorage extends RuntimeException{
    public FailToSaveInStorage(String msg){super(msg);}
}
