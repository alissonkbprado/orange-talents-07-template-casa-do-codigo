package br.com.zupacademy.alissonprado.casadocodigo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransacaoController {

    @PostMapping(value = "/transacao")
    public ResponseEntity<?> transacao(@RequestBody TransacaoRequest request) {

        Transacao transacao = request.getTipo().getTransacao();

        transacao.executa(request.getTipo(), request.getConta());

        return ResponseEntity.ok().build();
    }

}
