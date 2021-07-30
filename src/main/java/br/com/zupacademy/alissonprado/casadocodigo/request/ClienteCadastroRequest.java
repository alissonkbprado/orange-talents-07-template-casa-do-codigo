package br.com.zupacademy.alissonprado.casadocodigo.request;

import br.com.zupacademy.alissonprado.casadocodigo.model.Cliente;
import br.com.zupacademy.alissonprado.casadocodigo.model.Endereco;
import br.com.zupacademy.alissonprado.casadocodigo.model.Estado;
import br.com.zupacademy.alissonprado.casadocodigo.model.Pais;
import br.com.zupacademy.alissonprado.casadocodigo.validacao.CPForCNPJ;
import br.com.zupacademy.alissonprado.casadocodigo.validacao.ExistId;
import br.com.zupacademy.alissonprado.casadocodigo.validacao.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteCadastroRequest {

    @NotBlank
    private String nome;

    @NotBlank @Email
    @UniqueValue(domainClass = Cliente.class, fieldName = "email")
    private String email;

    @NotBlank
    @CPForCNPJ
    @UniqueValue(domainClass = Cliente.class, fieldName = "documento")
    private String documento;

    @NotBlank
    private String telefone;

    @NotBlank
    private String logradouro;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    private Integer cep;

    @NotNull
    @ExistId(domainClass = Pais.class, message = "O id do Pais informado não está cadatrado.")
    private String idPais;

    private String idEstado;

    public ClienteCadastroRequest(String nome, String email, String documento, String telefone, String logradouro, String complemento, String cidade, Integer cep, String idPais, String idEstado) {
        this.nome = nome;
        this.email = email;
        this.documento = documento.replaceAll("\\p{Punct}", "");
        this.telefone = telefone.replaceAll("\\p{Punct}", "");
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.cidade = cidade;
        this.cep = cep;
        this.idPais = idPais;
        this.idEstado = idEstado;
    }

    public Cliente toModel(){

        Estado estado = null;

        if(this.idEstado != null && !this.idEstado.isBlank()) {
            estado = new Estado(Long.parseLong(idEstado));
        }

        Pais pais = new Pais(Long.parseLong(this.idPais));

        Endereco endereco = new Endereco(this.logradouro, this.complemento, this.cidade, this.cep, pais, estado);

        return new Cliente(this.nome, this.email, this.documento, this.telefone, endereco);
    }

    public String getIdPais() {
        return idPais;
    }

    public String getIdEstado() {
        return idEstado;
    }

    public String getDocumento() {
        return documento;
    }
}
