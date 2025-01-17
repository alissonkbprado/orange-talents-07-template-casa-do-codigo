package br.com.zupacademy.alissonprado.casadocodigo.controller;

import br.com.zupacademy.alissonprado.casadocodigo.model.Estado;
import br.com.zupacademy.alissonprado.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.alissonprado.casadocodigo.request.EstadoCadastroRequest;
import br.com.zupacademy.alissonprado.casadocodigo.validacao.ProibeNomeEstadoEPaisDuplicadoEstadoValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    private EstadoRepository estadoRepository;
    private ProibeNomeEstadoEPaisDuplicadoEstadoValidator proibeNomeEstadoEPaisDuplicadoEstadoValidator;

    public EstadoController(EstadoRepository estadoRepository, ProibeNomeEstadoEPaisDuplicadoEstadoValidator proibeNomeEstadoEPaisDuplicadoValidator) {
        this.estadoRepository = estadoRepository;
        this.proibeNomeEstadoEPaisDuplicadoEstadoValidator = proibeNomeEstadoEPaisDuplicadoValidator;
    }

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(proibeNomeEstadoEPaisDuplicadoEstadoValidator);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid EstadoCadastroRequest estadoCadastroRequest){

        Estado estado = estadoCadastroRequest.toModel(estadoRepository);

        estadoRepository.save(estado);

        return ResponseEntity.status(200).build();
    }

}
