package br.com.ulkiorra.api.dto;

import lombok.Data;

@Data
public class LivroDTO {
    private Long id;
    private String titulo;
    private String isbn;
    private String nomeAutor;
    // Construtor, getters e setters são gerados pelo Lombok
    // Adicione outros campos conforme necessário
}