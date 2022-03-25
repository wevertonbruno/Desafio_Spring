package br.com.meli.grupo1.desafio_spring.DTO.purchases;

/*
 * DTO para receber um produto da compra
 * @Author Weverton Bruno
 * */
public class PurchaseDTO {
    private Long productId;
    private String name;
    private String brand;
    private Integer quantity;

    public PurchaseDTO() {
    }

    public PurchaseDTO(Long productId, String name, String brand, Integer quantity) {
        this.productId = productId;
        this.name = name;
        this.brand = brand;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
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
