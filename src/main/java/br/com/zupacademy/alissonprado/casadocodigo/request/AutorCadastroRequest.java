package br.com.zupacademy.alissonprado.casadocodigo.request;

import br.com.zupacademy.alissonprado.casadocodigo.model.Autor;
import br.com.zupacademy.alissonprado.casadocodigo.validacao.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AutorCadastroRequest {

    @NotNull @NotBlank @Size(min = 5, max = 250)
    private String nome;

    @NotNull @NotBlank @Email @Size(max = 250)
    @UniqueValue(domainClass = Autor.class, fieldName = "email")
    private String email;

    @NotNull @NotBlank @Size(max = 400)
    private String descricao;

    public AutorCadastroRequest(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor toModel() {
        return new Autor(this.nome, this.email, this.descricao);
    }
}
