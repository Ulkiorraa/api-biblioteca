package br.com.ulkiorra.api.service;
import br.com.ulkiorra.api.entity.Autor;
import br.com.ulkiorra.api.repository.AutorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Transactional
    public Autor salvarAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    public List<Autor> listarTodos() {
        return autorRepository.findAll();
    }

    public Optional<Autor> buscarPorId(Long id) {
        return autorRepository.findById(id);
    }

    @Transactional
    public Autor atualizarAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    @Transactional
    public void deletarAutor(Long id) {
        autorRepository.deleteById(id);
    }
}
