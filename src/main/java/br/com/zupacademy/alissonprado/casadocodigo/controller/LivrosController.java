package br.com.zupacademy.alissonprado.casadocodigo.controller;

import br.com.zupacademy.alissonprado.casadocodigo.model.Livro;
import br.com.zupacademy.alissonprado.casadocodigo.repository.LivroRepository;
import br.com.zupacademy.alissonprado.casadocodigo.request.LivroCadastroRequest;
import br.com.zupacademy.alissonprado.casadocodigo.response.LivroListProjectionResponse;
import br.com.zupacademy.alissonprado.casadocodigo.response.LivroDetalhesResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivrosController {

    private LivroRepository livroRepository;

    public LivrosController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid LivroCadastroRequest livroCadastroRequest){

        Livro livro = livroCadastroRequest.toModel();

        livroRepository.save(livro);

        return ResponseEntity.status(200).build();
    }

    @GetMapping
    public List<LivroListProjectionResponse> listar(@RequestParam(required = false) String titulo){

        if(titulo == null || titulo.isBlank())
            return  livroRepository.findLivros();

        return livroRepository.findLivrosByTitulo(titulo);

    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDetalhesResponse> detalhar(@PathVariable String id) {

        if (!id.matches("[0-9]*"))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Formato de id inválido");

        Optional<Livro> livroOptional = livroRepository.findById(Long.parseLong(id));

        if(livroOptional.isPresent())
            return ResponseEntity.ok(new LivroDetalhesResponse(livroOptional.get()));

        return ResponseEntity.status(404).build();


    }
}