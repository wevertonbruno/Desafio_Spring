package br.com.meli.grupo1.desafio_spring.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @author feito por todos
// resposta do cadastro concluido
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponseDTO {
    private Long clientId;
    private String name;
    private String email;
}
