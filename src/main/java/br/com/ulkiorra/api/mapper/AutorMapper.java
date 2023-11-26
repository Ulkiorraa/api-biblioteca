package br.com.ulkiorra.api.mapper;

import br.com.ulkiorra.api.dto.AutorDTO;
import br.com.ulkiorra.api.entity.Autor;
import org.springframework.stereotype.Component;

@Component
public class AutorMapper {

    public AutorDTO toDTO(Autor autor) {
        AutorDTO dto = new AutorDTO();
        dto.setId(autor.getId());
        dto.setNome(autor.getNome());
        return dto;
    }

    public Autor toEntity(AutorDTO dto) {
        Autor autor = new Autor();
        autor.setId(dto.getId());
        autor.setNome(dto.getNome());
        return autor;
    }
}