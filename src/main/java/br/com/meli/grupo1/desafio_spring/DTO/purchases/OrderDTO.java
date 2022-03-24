package br.com.meli.grupo1.desafio_spring.DTO.purchases;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderDTO {
    private Integer id;
    private BigDecimal total;
    private List<ArticleDTO> articles = new ArrayList<>();

    public OrderDTO(Integer id, List<ArticleDTO> articles) {
        this.id = id;
        this.articles = articles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<ArticleDTO> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleDTO> articles) {
        this.articles = articles;
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;

        for(ArticleDTO article: articles){
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
