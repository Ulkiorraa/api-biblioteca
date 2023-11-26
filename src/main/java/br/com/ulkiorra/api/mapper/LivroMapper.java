package br.com.ulkiorra.api.mapper;

import br.com.ulkiorra.api.dto.LivroDTO;
import br.com.ulkiorra.api.entity.Livro;
import org.springframework.stereotype.Component;

@Component
public class LivroMapper {

    public LivroDTO toDTO(Livro livro) {
        LivroDTO dto = new LivroDTO();
        dto.setId(livro.getId());
        dto.setTitulo(livro.getTitulo());
        dto.setIsbn(livro.getIsbn());
        if (livro.getAutor() != null) {
            dto.setNomeAutor(livro.getAutor().getNome());
        }
        if (livro.getAutor() != null) {
            dto.setAutorId(livro.getAutor().getId());
        }
        return dto;
    }

    public Livro toEntity(LivroDTO dto) {
        Livro livro = new Livro();
        livro.setId(dto.getId());
        livro.setTitulo(dto.getTitulo());
        livro.setIsbn(dto.getIsbn());
        // O mapeamento do autor será tratado separadamente, pois requer acesso ao repositório de Autor
        return livro;
    }
}
