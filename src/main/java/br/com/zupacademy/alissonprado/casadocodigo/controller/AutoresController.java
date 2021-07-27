package br.com.zupacademy.alissonprado.casadocodigo.controller;

import br.com.zupacademy.alissonprado.casadocodigo.model.Autor;
import br.com.zupacademy.alissonprado.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.alissonprado.casadocodigo.request.AutorRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> cadastrar(@RequestBody @Valid AutorRequest autorRequest){

        Autor autor = autorRequest.toModel();

        autorRepository.save(autor);

        return ResponseEntity.status(200).build();
    }
}
