package br.com.zupacademy.alissonprado.casadocodigo.request;

import br.com.zupacademy.alissonprado.casadocodigo.model.Categoria;
import br.com.zupacademy.alissonprado.casadocodigo.validacao.UniqueValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class CategoriaCadastroRequest {

    @NotBlank @Size(max = 250)
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    @JsonCreator
    public CategoriaCadastroRequest(@JsonProperty("nome") String nome) {
        this.nome = nome;
    }

    public Categoria toModel() {
        return new Categoria(this.nome);
    }

}