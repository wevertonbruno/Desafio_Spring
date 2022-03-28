package br.com.meli.grupo1.desafio_spring.exceptions;

/*
 * Exeption para compras que nao foram possiveis serem salvas
 * @author Gabriel Essenio
 */

public class FailToSaveInStorage extends RuntimeException{
    public FailToSaveInStorage(String msg){super(msg);}
}
