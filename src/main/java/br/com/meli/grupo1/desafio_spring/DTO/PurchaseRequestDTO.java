package br.com.meli.grupo1.desafio_spring.DTO;

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

    public class Purchase {
        private Integer productId;
        private String name;
        private String brand;
        private Integer quantity;

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

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }
    }
}
