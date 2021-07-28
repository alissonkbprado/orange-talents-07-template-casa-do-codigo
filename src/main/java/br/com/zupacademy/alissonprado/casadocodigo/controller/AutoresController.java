package br.com.zupacademy.alissonprado.casadocodigo.controller;

import br.com.zupacademy.alissonprado.casadocodigo.model.Autor;
import br.com.zupacademy.alissonprado.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.alissonprado.casadocodigo.request.AutorCadastroRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutoresController {

    private AutorRepository autorRepository;

    public AutoresController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid AutorCadastroRequest autorCadastroRequest){

        Autor autor = autorCadastroRequest.toModel();

        autorRepository.save(autor);

        return ResponseEntity.status(200).build();
    }
}
