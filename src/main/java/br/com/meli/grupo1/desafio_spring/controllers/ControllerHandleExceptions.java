package br.com.meli.grupo1.desafio_spring.controllers;

import br.com.meli.grupo1.desafio_spring.exceptions.EmptyPurchaseException;
import br.com.meli.grupo1.desafio_spring.exceptions.FailToSaveInStorage;
import br.com.meli.grupo1.desafio_spring.exceptions.UnregisteredProductException;
import br.com.meli.grupo1.desafio_spring.exceptions.StandardException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/*
* Classe que captura as exceptions lancadas nas camadas de controller -> services -> repositories
* @author Weverton Bruno e Gabriel Essenio
* */
@RestControllerAdvice
public class ControllerHandleExceptions {

    /*
    * Bad Request quando o produto nao existe
    * */
    @ExceptionHandler(UnregisteredProductException.class)
    public ResponseEntity<StandardException> unregistred(UnregisteredProductException e, HttpServletRequest request){
        StandardException response = StandardException.notFound(e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    /*
     * Bad Request quando o usuario tenta fazer uma compra sem produtos
     * */
    @ExceptionHandler(EmptyPurchaseException.class)
    public ResponseEntity<StandardException> emptyPurchaseRequest(EmptyPurchaseException e, HttpServletRequest request) {
        StandardException response = StandardException.badRequest(e.getMessage(), request.getRequestURI());
        return ResponseEntity.badRequest().body(response);
    }

    /*
     * Internal Server Error quando ocorre uma falha ao persistir os dados Json
     * */
    @ExceptionHandler(FailToSaveInStorage.class)
    public ResponseEntity<StandardException> failToSaveInStorage(FailToSaveInStorage e, HttpServletRequest request){
        StandardException response = StandardException.internalError(e.getMessage(), request.getRequestURI());
        return ResponseEntity.internalServerError().body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardException> argumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request){
        StandardException response = StandardException.badRequest(e.getFieldError().getDefaultMessage(), request.getRequestURI());
        return ResponseEntity.badRequest().body(response);
    }
}
