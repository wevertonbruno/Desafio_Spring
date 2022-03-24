package br.com.meli.grupo1.desafio_spring.DTO.purchases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PurchaseRequestDTO implements Serializable {

    private List<Purchase> articlesPurchaseRequest = new ArrayList<>();

    public PurchaseRequestDTO(List<Purchase> articlesPurchaseRequest){
        this.articlesPurchaseRequest = articlesPurchaseRequest;
    }

    public List<Purchase> getArticlesPurchaseRequest() {
        return articlesPurchaseRequest;
    }

    public void setArticlesPurchaseRequest(List<Purchase> articlesPurchaseRequest) {
        this.articlesPurchaseRequest = articlesPurchaseRequest;
    }

}
