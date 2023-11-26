package br.com.ulkiorra.api.service;
import br.com.ulkiorra.api.entity.Livro;
import br.com.ulkiorra.api.repository.LivroRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @Transactional
    public Livro salvarLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    public Optional<Livro> buscarPorId(Long id) {
        return livroRepository.findById(id);
    }

    @Transactional
    public Livro atualizarLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    @Transactional
    public void deletarLivro(Long id) {
        livroRepository.deleteById(id);
    }
}
