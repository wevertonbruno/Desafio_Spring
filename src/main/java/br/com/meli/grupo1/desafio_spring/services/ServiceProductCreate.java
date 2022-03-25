package br.com.meli.grupo1.desafio_spring.services;

import br.com.meli.grupo1.desafio_spring.DTO.CreateRequestDTO;
import br.com.meli.grupo1.desafio_spring.DTO.ProductCreateResponseDTO;
import br.com.meli.grupo1.desafio_spring.DTO.ProductDTO;
import br.com.meli.grupo1.desafio_spring.entities.Product;
import br.com.meli.grupo1.desafio_spring.repositories.RepoCreateProduct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceProductCreate {
    RepoCreateProduct repoCreateProduct;

    public ServiceProductCreate(RepoCreateProduct repoCreateProduct) {
        this.repoCreateProduct = repoCreateProduct;
    }

    public ProductCreateResponseDTO create(CreateRequestDTO products){
        List<Product> createdProducts = repoCreateProduct.create(products.getArticles());
        List<ProductDTO> productDTOS = createdProducts
                .stream()
                .map(product -> new ProductDTO(product.getProductId(), product.getName(), product.getQuantity()))
                .collect(Collectors.toList());
        return new ProductCreateResponseDTO(productDTOS);
    }

}
