package br.com.meli.grupo1.desafio_spring.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @author feito por todos
// vai receber os atributos para cadastrar o cliente

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientDTO {
    private String nome;
    private String email;
    private String cep;
    private String endereco;
    private String estado;
    private String senha;
}
