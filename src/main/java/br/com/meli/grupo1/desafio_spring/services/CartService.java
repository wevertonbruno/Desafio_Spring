package br.com.meli.grupo1.desafio_spring.services;

import br.com.meli.grupo1.desafio_spring.DTO.cart.CartResponseDTO;
import br.com.meli.grupo1.desafio_spring.entities.Order;
import br.com.meli.grupo1.desafio_spring.repositories.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;


/*
* Classe de servico para gerar o total de compras no cart
* @author Weverton Bruno
* */
@Service
public class CartService {
    private CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    /*
    * Pega do repositorio todas as compras do usuario e retorna o total como cart
    * */
    public CartResponseDTO cart(){
        List<Order> allOrders = cartRepository.getAllOrder();
        return new CartResponseDTO(allOrders);
    }
}
