package br.com.meli.grupo1.desafio_spring.exceptions;

import org.springframework.http.HttpStatus;

import java.time.Instant;

/*
* Exception padrao personalizada, responsavel por enviar para o usuario uma resposta de erro padronizada.
* @author Weverton Bruno
* */
public class StandardException {
    private Integer status;
    private String msg;
    private Instant timestamp;
    private String path;

    public StandardException(Integer status, String msg, Instant timestamp, String path) {
        this.status = status;
        this.msg = msg;
        this.timestamp = timestamp;
        this.path = path;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public static StandardException notFound(String msg, String path){
        return new StandardException(HttpStatus.NOT_FOUND.value(), msg, Instant.now(), path);
    }

    public static StandardException badRequest(String msg, String path){
        return new StandardException(HttpStatus.BAD_REQUEST.value(), msg, Instant.now(), path);
    }

    public  static StandardException internalError(String msg, String path){
        return new StandardException(HttpStatus.SERVICE_UNAVAILABLE.value(), msg, Instant.now(), path);
    }

    @Override
    public String toString() {
        return "StandardException{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", timestamp=" + timestamp +
                ", path='" + path + '\'' +
                '}';
    }
}
