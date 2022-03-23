package br.com.meli.grupo1.desafio_spring.services;

import br.com.meli.grupo1.desafio_spring.DTO.ArticlesDTO;
import org.springframework.stereotype.Service;

@Service
public class GetArticleService {
    public static ArticlesDTO findArticles (String category, Boolean freeShipping, String productName, String brandName, Integer typeOrder) {

        return new ArticlesDTO();
    }
}
