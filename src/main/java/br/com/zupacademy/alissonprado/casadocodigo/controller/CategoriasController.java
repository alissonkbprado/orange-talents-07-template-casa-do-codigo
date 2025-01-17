package br.com.zupacademy.alissonprado.casadocodigo.controller;

import br.com.zupacademy.alissonprado.casadocodigo.model.Categoria;
import br.com.zupacademy.alissonprado.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.alissonprado.casadocodigo.request.CategoriaCadastroRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<?> cadastrar(@RequestBody @Valid CategoriaCadastroRequest categoriaCadastroRequest){

        Categoria categoria = categoriaCadastroRequest.toModel();

        categoriaRepository.save(categoria);

        return ResponseEntity.status(200).build();
    }
}
