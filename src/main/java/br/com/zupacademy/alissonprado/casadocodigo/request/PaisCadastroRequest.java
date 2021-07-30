package br.com.zupacademy.alissonprado.casadocodigo.request;

import br.com.zupacademy.alissonprado.casadocodigo.model.Pais;
import br.com.zupacademy.alissonprado.casadocodigo.validacao.UniqueValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PaisCadastroRequest {

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    @JsonCreator
    public PaisCadastroRequest(@JsonProperty("nome") String nome) {
        this.nome = nome;
    }

    public Pais toModel() {
        return new Pais(this.nome);
    }
}
