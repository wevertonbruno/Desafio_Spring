package br.com.meli.grupo1.desafio_spring.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private Long clienteId;
    private String nome;
    private String email;
    private String cep;
    private String endereco;
    private String estado;
    private String senha;
}
