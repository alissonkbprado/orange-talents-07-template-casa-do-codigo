package br.com.zupacademy.alissonprado.casadocodigo.controller;

import br.com.zupacademy.alissonprado.casadocodigo.model.Livro;
import br.com.zupacademy.alissonprado.casadocodigo.repository.LivroRepository;
import br.com.zupacademy.alissonprado.casadocodigo.request.LivroRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

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
}
