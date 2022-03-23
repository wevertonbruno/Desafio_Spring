package br.com.meli.grupo1.desafio_spring.services;

import br.com.meli.grupo1.desafio_spring.DTO.ArticlesDTO;
import br.com.meli.grupo1.desafio_spring.entities.Article;
import br.com.meli.grupo1.desafio_spring.repositories.GetAllArticles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetArticleService {
    @Autowired
    private GetAllArticles articles;

    public ArticlesDTO findArticles (String category, Boolean freeShipping, String productName, String brandName, Integer typeOrder) {
        List<Article> articlesList = articles.getAll();
        if (category != null && articlesList != null)
            articlesList = articlesList
                    .stream()
                    .filter(article -> article.getCategory().equals(category))
                    .collect(Collectors.toList());
        if (freeShipping != null && articlesList != null)
            articlesList = articlesList
                    .stream()
                    .filter(article -> article.isFreeShipping() && freeShipping)
                    .collect(Collectors.toList());
        if (productName != null && articlesList != null)
            articlesList = articlesList
                    .stream()
                    .filter(article -> article.getBrand().equals(productName))
                    .collect(Collectors.toList());
        if (brandName != null && articlesList != null)
            articlesList = articlesList
                    .stream()
                    .filter(article -> article.getBrand().equals(brandName))
                    .collect(Collectors.toList());
        if (typeOrder != null && articlesList != null)
            switch (typeOrder){
                case 0:
                    articlesList = articlesList
                            .stream()
                            .sorted((a, b) -> a.getName().compareTo(b.getName()))
                            .collect(Collectors.toList());
                    break;
                case 1:
                    articlesList = articlesList
                            .stream()
                            .sorted((a, b) -> b.getName().compareTo(a.getName()))
                            .collect(Collectors.toList());
                    break;
                case 2:
                    articlesList = articlesList
                            .stream()
                            .sorted((a, b) -> b.getPrice().compareTo(a.getPrice()))
                            .collect(Collectors.toList());
                    break;
                case 3:
                    articlesList = articlesList
                            .stream()
                            .sorted((a, b) -> a.getPrice().compareTo(b.getPrice()))
                            .collect(Collectors.toList());
                    break;
            }




        return new ArticlesDTO(articlesList);
    }
}
