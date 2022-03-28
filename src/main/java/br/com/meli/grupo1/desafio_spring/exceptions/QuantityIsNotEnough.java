package br.com.meli.grupo1.desafio_spring.exceptions;


/*
 * Exeption para assinalar quando uma compra não é possível por falta de item em estoque
 * @author Rogerio Lambert
 */

public class QuantityIsNotEnough extends RuntimeException{
    public QuantityIsNotEnough(String msg){
        super(msg);
    }
}
