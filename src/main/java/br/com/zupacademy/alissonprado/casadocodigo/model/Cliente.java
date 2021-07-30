package br.com.zupacademy.alissonprado.casadocodigo.model;

import br.com.zupacademy.alissonprado.casadocodigo.validacao.CPForCNPJ;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String nome;

    @NotBlank @Email
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank
    @CPForCNPJ
    @Column(unique = true, nullable = false)
    private String documento;

    @NotBlank
    @Column(nullable = false)
    private String telefone;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    /**
     * Não utilizar.
     * Criado por exigencia da JPA
     */
    @Deprecated
    public Cliente() {
    }

    /**
     *
     * @param nome NotNull
     * @param email NotNull, Unique
     * @param documento NotNull, Unique, CPF or CNPJ
     * @param telefone NotNull
     * @param endereco NotNull
     */
    public Cliente(String nome, String email, String documento, String telefone, Endereco endereco) {
        if(nome.isBlank() || email.isBlank() || documento.isBlank() || telefone.isBlank() || endereco == null)
            throw new IllegalArgumentException("Todos os dados de Cliente devem ser preenchidos.");
        this.nome = nome;
        this.email = email;
        this.documento = documento;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }
}
