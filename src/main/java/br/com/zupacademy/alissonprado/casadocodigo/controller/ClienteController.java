package br.com.zupacademy.alissonprado.casadocodigo.controller;

import br.com.zupacademy.alissonprado.casadocodigo.model.Cliente;
import br.com.zupacademy.alissonprado.casadocodigo.repository.ClienteRepository;
import br.com.zupacademy.alissonprado.casadocodigo.request.ClienteCadastroRequest;
import br.com.zupacademy.alissonprado.casadocodigo.response.ClienteCadastroResponse;
import br.com.zupacademy.alissonprado.casadocodigo.validacao.ProibeEstadoSemPaisCadastradoValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteRepository clienteRepository;
    private ProibeEstadoSemPaisCadastradoValidator proibeEstadoSemPaisCadastradoValidator;

    public ClienteController(ClienteRepository clienteRepository, ProibeEstadoSemPaisCadastradoValidator proibeEstadoSemPaisCadastradoValidator) {
        this.clienteRepository = clienteRepository;
        this.proibeEstadoSemPaisCadastradoValidator = proibeEstadoSemPaisCadastradoValidator;
    }

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(proibeEstadoSemPaisCadastradoValidator);
    }

    @PostMapping
    public ResponseEntity<ClienteCadastroResponse> cadastrar(@RequestBody @Valid ClienteCadastroRequest clienteCadastroRequest){

        Cliente cliente = clienteCadastroRequest.toModel();

        clienteRepository.save(cliente);

        return ResponseEntity.ok(new ClienteCadastroResponse(cliente.getId()));
    }
}
