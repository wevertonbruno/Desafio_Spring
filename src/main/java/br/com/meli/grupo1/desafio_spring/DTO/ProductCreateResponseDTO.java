package br.com.meli.grupo1.desafio_spring.DTO;

import br.com.meli.grupo1.desafio_spring.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateResponseDTO {
    List<ProductDTO> articlesDTO;
}
