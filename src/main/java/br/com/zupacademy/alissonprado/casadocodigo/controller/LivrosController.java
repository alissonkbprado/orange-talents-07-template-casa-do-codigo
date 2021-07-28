package br.com.zupacademy.alissonprado.casadocodigo.controller;

import br.com.zupacademy.alissonprado.casadocodigo.model.Livro;
import br.com.zupacademy.alissonprado.casadocodigo.repository.LivroRepository;
import br.com.zupacademy.alissonprado.casadocodigo.request.LivroRequest;
import br.com.zupacademy.alissonprado.casadocodigo.response.LivroListProjectionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivrosController {

    private LivroRepository livroRepository;

    public LivrosController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid LivroRequest livroRequest){

        Livro livro = livroRequest.toModel();

        livroRepository.save(livro);

        return ResponseEntity.status(200).build();
    }

    @GetMapping
    public List<LivroListProjectionResponse> listar(@RequestParam(required = false) String titulo){

        if(titulo.isBlank())
            return  livroRepository.findLivros();

        return livroRepository.findLivrosByTitulo(titulo);

    }
}


















