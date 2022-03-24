package br.com.meli.grupo1.desafio_spring.DTO.purchases;

public class PurchaseDTO {
    private Integer productId;
    private String name;
    private String brand;
    private Integer quantity;

    public PurchaseDTO() {
    }

    public PurchaseDTO(Integer productId, String name, String brand, Integer quantity) {
        this.productId = productId;
        this.name = name;
        this.brand = brand;
        this.quantity = quantity;
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
