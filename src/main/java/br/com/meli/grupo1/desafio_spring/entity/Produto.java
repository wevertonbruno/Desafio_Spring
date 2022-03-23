package br.com.meli.grupo1.desafio_spring.entity;

import java.math.BigDecimal;

public class Produto<Interger> {
    private long productId;
    private String name;
    private String category;
    private String brand;
    private BigDecimal price;
    private Interger quantity;
    private boolean freeShipping;
    private String prestige;

    public Produto(long productId, String name, String category, String brand, BigDecimal price, Interger quantity,
                   boolean freeShipping, String prestige) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        this.freeShipping = freeShipping;
        this.prestige = prestige;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
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

    public Interger getQuantity() {
        return quantity;
    }

    public void setQuantity(Interger quantity) {
        this.quantity = quantity;
    }

    public boolean isFreeShipping() {
        return freeShipping;
    }

    public void setFreeShipping(boolean freeShipping) {
        this.freeShipping = freeShipping;
    }

    public String getPrestige() {
        return prestige;
    }

    public void setPrestige(String prestige) {
        this.prestige = prestige;
    }

}
