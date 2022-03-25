package br.com.meli.grupo1.desafio_spring.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/*
 * Implementação da entidade produtos
 * @author Ederson Rodrigues e Nayara Coca
 */

/**
 * Por fins didaticos, os autores realizaram a implementacao dos gatters e setters e construtor da classe,
 * o codigo foi refatorado, por Jefferson, e adicionado as notacoes do lombok, que ira instanciar os codigos automaticamente quando for ser gerado o byte code, interpretado pela JVM
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
    @NotNull(message = "Nao e permitido valores nulos no Id do produto")
    @Min(value = 1L, message = "O valor minimo do Id do produto e 1")
    private Long productId;
    @NotBlank(message = "Nome obrigatório!")
    private String name;
    private String category;
    private String brand;
    @NotNull
    private BigDecimal price;
    @NotNull(message = "Nao e permitido quantidade no valor de nulo")
    @Min(value = 0,message = "Valor minimo da quantidade e 0")
    private Integer quantity;
    private Boolean freeShipping;
    private String prestige;
}
