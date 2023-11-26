package br.com.ulkiorra.api.http.controller;

import br.com.ulkiorra.api.dto.AutorDTO;
import br.com.ulkiorra.api.entity.Autor;
import br.com.ulkiorra.api.mapper.AutorMapper;
import br.com.ulkiorra.api.service.AutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorService autorService;
    private final AutorMapper autorMapper;

    public AutorController(AutorService autorService, AutorMapper autorMapper) {
        this.autorService = autorService;
        this.autorMapper = autorMapper;
    }

    @PostMapping
    public ResponseEntity<AutorDTO> criarAutor(@RequestBody AutorDTO autorDTO) {
        Autor autor = autorMapper.toEntity(autorDTO);
        Autor novoAutor = autorService.salvarAutor(autor);
        return ResponseEntity.ok(autorMapper.toDTO(novoAutor));
    }

    @GetMapping
    public ResponseEntity<List<AutorDTO>> listarAutores() {
        List<Autor> autores = autorService.listarTodos();
        List<AutorDTO> autoresDTO = autores.stream()
                .map(autorMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(autoresDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorDTO> buscarAutorPorId(@PathVariable Long id) {
        return autorService.buscarPorId(id)
                .map(autor -> ResponseEntity.ok(autorMapper.toDTO(autor)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorDTO> atualizarAutor(@PathVariable Long id, @RequestBody AutorDTO autorDTO) {
        return autorService.buscarPorId(id).map(autorExistente -> {
            Autor autor = autorMapper.toEntity(autorDTO);
            autor.setId(id); // Mantém o mesmo ID
            Autor autorAtualizado = autorService.atualizarAutor(autor);
            return ResponseEntity.ok(autorMapper.toDTO(autorAtualizado));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAutor(@PathVariable Long id) {
        return autorService.buscarPorId(id).map(autor -> {
            autorService.deletarAutor(id);
            return new ResponseEntity<Void>(HttpStatus.OK); // Retorno correto para ResponseEntity<Void>
        }).orElse(new ResponseEntity<Void>(HttpStatus.NOT_FOUND)); // Retorno correto para ResponseEntity<Void>
    }
}
