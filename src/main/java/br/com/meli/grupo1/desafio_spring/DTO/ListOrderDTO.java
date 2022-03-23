package br.com.meli.grupo1.desafio_spring.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ListOrderDTO implements Serializable {
    private OrderDTO ticket;

    public ListOrderDTO(OrderDTO ticket) {
        this.ticket = ticket;
    }

    public OrderDTO getTicket() {
        return ticket;
    }

    public void setTicket(OrderDTO ticket) {
        this.ticket = ticket;
    }

    public class OrderDTO{
        private Integer id;
        private Integer total;
        private List<ArticleDTO> articles= new ArrayList<>();

        public OrderDTO(Integer id, List<ArticleDTO> articles, Integer total) {
            this.id = id;
            this.articles = articles;
            this.total = total;
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

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        @Override
        public String toString() {
            return "OrderDTO{" +
                    "id=" + id +
                    ", total=" + total +
                    ", articles=" + articles +
                    '}';
        }
    }

    public class ArticleDTO{
        private Integer productId;
        private String name;
        private String category;
        private String brand;
        private BigDecimal price;
        private Integer quantity;
        private Boolean freeShipping;
        private String prestige;

        public ArticleDTO(Integer productId, String name, String category, String brand, BigDecimal price, Integer quantity, Boolean freeShipping, String prestige) {
            this.productId = productId;
            this.name = name;
            this.category = category;
            this.brand = brand;
            this.price = price;
            this.quantity = quantity;
            this.freeShipping = freeShipping;
            this.prestige = prestige;
        }

        public Integer getProductId() {
            return productId;
        }

        public void setProductId(Integer productId) {
            this.productId = productId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public Boolean getFreeShipping() {
            return freeShipping;
        }

        public void setFreeShipping(Boolean freeShipping) {
            this.freeShipping = freeShipping;
        }

        public String getPrestige() {
            return prestige;
        }

        public void setPrestige(String prestige) {
            this.prestige = prestige;
        }

        @Override
        public String toString() {
            return "ArticleDTO{" +
                    "productId=" + productId +
                    ", name='" + name + '\'' +
                    ", category='" + category + '\'' +
                    ", brand='" + brand + '\'' +
                    ", price=" + price +
                    ", quantity=" + quantity +
                    ", freeShipping=" + freeShipping +
                    ", prestige='" + prestige + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ListOrderDTO{" +
                "ticket=" + ticket +
                '}';
    }
}
