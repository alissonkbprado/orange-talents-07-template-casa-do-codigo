package br.com.zupacademy.alissonprado.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Pais {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true, nullable = false)
    private String nome;

    /**
     * Não utilizar.
     * Criado por exigencia da JPA
     */
    @Deprecated
    public Pais() {
    }

    /**
     *
     * @param nome Unique
     */
    public Pais(String nome) {
        if(nome.isBlank())
            throw new IllegalArgumentException("Todos os dados de Pais devem ser preenchidos.");
        this.nome = nome;
    }

    public Pais(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
