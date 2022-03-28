package br.com.meli.grupo1.desafio_spring.DTO.cart;

import br.com.meli.grupo1.desafio_spring.entities.Order;
import br.com.meli.grupo1.desafio_spring.entities.Purchase;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartResponseDTO {
    @JsonIgnore
    List<Order> orders;

    public BigDecimal getTotalCart(){
        BigDecimal total = BigDecimal.ZERO;

        for(Order order : orders){
            for (Purchase purchase: order.getPurchases()){
                BigDecimal price = purchase.getProduct().getPrice();
                BigDecimal quantity = BigDecimal.valueOf(purchase.getQuantity());
                total = total.add(price.multiply(quantity));
            }
        }
        return total;
    }
}
