package br.com.zupacademy.alissonprado.casadocodigo.controller;

import br.com.zupacademy.alissonprado.casadocodigo.model.Pais;
import br.com.zupacademy.alissonprado.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.alissonprado.casadocodigo.request.PaisCadastroRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {

    private PaisRepository paisRepository;

    public PaisController(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid PaisCadastroRequest paisCadastroRequest){

        Pais pais = paisCadastroRequest.toModel();

        paisRepository.save(pais);

        return ResponseEntity.status(200).build();
    }

}
