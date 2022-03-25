package br.com.meli.grupo1.desafio_spring.DTO;

import br.com.meli.grupo1.desafio_spring.entities.Product;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * O objeto que recebe a requisucao
 * @author Ederson Rodrigues e Nayara Coca
 */

public class CreateRequestDTO {
    @Valid
    private List<Product> articles = new ArrayList<>();

    public List<Product> getArticles() {
        return articles;
    }

    public void setArticles(List<Product> articles) {
        this.articles = articles;
    }

    public CreateRequestDTO() {
    }

    public CreateRequestDTO(List<Product> articles) {
        this.articles = articles;
    }
}
