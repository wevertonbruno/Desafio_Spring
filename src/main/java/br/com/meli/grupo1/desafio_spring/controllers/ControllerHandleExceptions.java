package br.com.meli.grupo1.desafio_spring.controllers;

import br.com.meli.grupo1.desafio_spring.exceptions.UnregisteredProductException;
import br.com.meli.grupo1.desafio_spring.exceptions.StandardException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ControllerHandleExceptions {
    @ExceptionHandler(UnregisteredProductException.class)
    public ResponseEntity<StandardException> unregistred(UnregisteredProductException e, HttpServletRequest request){
        StandardException response = StandardException.badRequest(e.getMessage(), request.getRequestURI());
        return ResponseEntity.badRequest().body(response);
    }
}
