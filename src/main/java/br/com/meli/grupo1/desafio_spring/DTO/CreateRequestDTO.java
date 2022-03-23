package br.com.meli.grupo1.desafio_spring.DTO;

import br.com.meli.grupo1.desafio_spring.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class CreateRequestDTO {
    private List<Product> articles = new ArrayList<>();

    public List<Product> getArticles() {
        return articles;
    }

    public void setArticles(List<Product> articles) {
        this.articles = articles;
    }

    public CreateRequestDTO(List<Product> articles) {
        this.articles = articles;
    }
}
