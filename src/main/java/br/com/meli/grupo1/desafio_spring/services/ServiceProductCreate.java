package br.com.meli.grupo1.desafio_spring.services;

import br.com.meli.grupo1.desafio_spring.DTO.CreateRequestDTO;
import br.com.meli.grupo1.desafio_spring.DTO.ProductCreateResponseDTO;
import br.com.meli.grupo1.desafio_spring.entities.Product;
import br.com.meli.grupo1.desafio_spring.repositories.RepoCreateProduct;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceProductCreate {
    RepoCreateProduct repoCreateProduct;

    public ServiceProductCreate(RepoCreateProduct repoCreateProduct) {
        this.repoCreateProduct = repoCreateProduct;
    }

    public ProductCreateResponseDTO create(CreateRequestDTO products){
    ProductCreateResponseDTO responseDTO = repoCreateProduct.create(products.getArticles());
        return responseDTO;
    }

}
