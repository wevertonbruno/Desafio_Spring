package br.com.meli.grupo1.desafio_spring.exceptions;

/*
 * Exeption para compras que o produto nao esta cadastrado
 * @author Gabriel Essenio
 */

public class UnregisteredProductException extends RuntimeException{
    public UnregisteredProductException(String msg){
        super(msg);
    }
}
