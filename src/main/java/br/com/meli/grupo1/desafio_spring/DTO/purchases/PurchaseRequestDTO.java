package br.com.meli.grupo1.desafio_spring.DTO.purchases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
* DTO para receber a request de compra
* @author Weverton Bruno
* */
public class PurchaseRequestDTO implements Serializable {

    private List<PurchaseDTO> articlesPurchaseRequest = new ArrayList<>();

    public PurchaseRequestDTO(){}

    public PurchaseRequestDTO(List<PurchaseDTO> articlesPurchaseRequest){
        this.articlesPurchaseRequest = articlesPurchaseRequest;
    }

    public List<PurchaseDTO> getArticlesPurchaseRequest() {
        return articlesPurchaseRequest;
    }

    public void setArticlesPurchaseRequest(List<PurchaseDTO> articlesPurchaseRequest) {
        this.articlesPurchaseRequest = articlesPurchaseRequest;
    }

}
