package br.com.zupacademy.alissonprado.casadocodigo.request;

import br.com.zupacademy.alissonprado.casadocodigo.model.Estado;
import br.com.zupacademy.alissonprado.casadocodigo.model.Pais;
import br.com.zupacademy.alissonprado.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.alissonprado.casadocodigo.validacao.ExistId;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class EstadoCadastroRequest {

    @NotBlank
    @Size(max = 250)
    private String nome;

    @NotBlank
    @ExistId(domainClass = Pais.class, message = "O id do Pais informado não está cadatrado.")
    private String idPais;

    public EstadoCadastroRequest(String nome, String idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }

    public Estado toModel(EstadoRepository estadoRepository) {
        return new Estado(this.nome,new Pais(Long.parseLong(idPais)));
    }

    public String getNome() {
        return nome;
    }

    public String getIdPais() {
        return idPais;
    }
}