package br.com.zupacademy.alissonprado.casadocodigo.controller;

import br.com.zupacademy.alissonprado.casadocodigo.model.Categoria;
import br.com.zupacademy.alissonprado.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.alissonprado.casadocodigo.request.CategoriaRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {

    private CategoriaRepository categoriaRepository;


    public CategoriasController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid CategoriaRequest categoriaRequest){

        Categoria categoria = categoriaRequest.toModel();

        categoriaRepository.save(categoria);

        return ResponseEntity.status(200).build();
    }
}
