package br.com.ulkiorra.api.http.controller;

import br.com.ulkiorra.api.dto.LivroDTO;
import br.com.ulkiorra.api.entity.Livro;
import br.com.ulkiorra.api.mapper.LivroMapper;
import br.com.ulkiorra.api.repository.AutorRepository;
import br.com.ulkiorra.api.service.LivroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;
    private final LivroMapper livroMapper;
    private final AutorRepository autorRepository; // Presumindo que você precisa disso para mapeamento

    public LivroController(LivroService livroService, LivroMapper livroMapper, AutorRepository autorRepository) {
        this.livroService = livroService;
        this.livroMapper = livroMapper;
        this.autorRepository = autorRepository;
    }

    @PostMapping
    public ResponseEntity<LivroDTO> criarLivro(@RequestBody LivroDTO livroDTO) {
        Livro livro = livroMapper.toEntity(livroDTO);
        autorRepository.findById(livroDTO.getAutorId()).ifPresent(livro::setAutor);
        Livro novoLivro = livroService.salvarLivro(livro);
        return ResponseEntity.ok(livroMapper.toDTO(novoLivro));
    }

    @GetMapping
    public ResponseEntity<List<LivroDTO>> listarLivros() {
        List<Livro> livros = livroService.listarTodos();
        List<LivroDTO> livrosDTO = livros.stream()
                .map(livroMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(livrosDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDTO> buscarLivroPorId(@PathVariable Long id) {
        return livroService.buscarPorId(id)
                .map(livro -> ResponseEntity.ok(livroMapper.toDTO(livro)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroDTO> atualizarLivro(@PathVariable Long id, @RequestBody LivroDTO livroDTO) {
        return livroService.buscarPorId(id).map(livroExistente -> {
            Livro livro = livroMapper.toEntity(livroDTO);
            livro.setId(id); // Mantém o mesmo ID
            autorRepository.findById(livroDTO.getAutorId()).ifPresent(livro::setAutor);
            Livro livroAtualizado = livroService.atualizarLivro(livro);
            return ResponseEntity.ok(livroMapper.toDTO(livroAtualizado));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Long id) {
        return livroService.buscarPorId(id).map(livro -> {
            livroService.deletarLivro(id);
            return new ResponseEntity<Void>(HttpStatus.OK); // Retorno correto para ResponseEntity<Void>
        }).orElse(new ResponseEntity<Void>(HttpStatus.NOT_FOUND)); // Retorno correto para ResponseEntity<Void>
    }
}

