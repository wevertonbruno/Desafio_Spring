package br.com.meli.grupo1.desafio_spring.services;

import br.com.meli.grupo1.desafio_spring.DTO.ListOrderDTO;
import br.com.meli.grupo1.desafio_spring.DTO.PurchaseRequestDTO;
import br.com.meli.grupo1.desafio_spring.exceptions.UnregisteredProductException;
import br.com.meli.grupo1.desafio_spring.repositories.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {

    private PurchaseRepository purchaseRepository;

    public PurchaseService(PurchaseRepository purchaseRepository){
        this.purchaseRepository = purchaseRepository;
    }

    public ListOrderDTO purchaseOrder(PurchaseRequestDTO products){
        //Validar se o produto existe
        boolean verifyProduct = products.getArticlesPurchaseRequest().stream()
                .filter(p -> !purchaseRepository.existProduct(p.getProductId()))
                .findAny()
                .isEmpty();
        if (verifyProduct){
            throw new UnregisteredProductException("Produto solicitado nao cadastrado ");
        }



        //buscar os produtos do repositorio

        //mapear para o DTO

        //retornar o dto
        return null;
    }
}
