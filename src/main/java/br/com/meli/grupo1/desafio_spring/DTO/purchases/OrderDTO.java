package br.com.meli.grupo1.desafio_spring.DTO.purchases;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/*
 * DTO para receber a response ticket de compra de produto
 * @author Gabriel Essenio
 * */

public class OrderDTO {
    private Integer id;
    private BigDecimal total;
    private List<PurchaseArticleDTO> articles = new ArrayList<>();

    public OrderDTO() {
    }

    public OrderDTO(Integer id, List<PurchaseArticleDTO> articles) {
        this.id = id;
        this.articles = articles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<PurchaseArticleDTO> getArticles() {
        return articles;
    }

    public void setArticles(List<PurchaseArticleDTO> articles) {
        this.articles = articles;
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;

        for(PurchaseArticleDTO article: articles){
            total = total.add(article.getSubTotal());
        }

        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", total=" + getTotal() +
                ", articles=" + articles +
                '}';
    }
}
