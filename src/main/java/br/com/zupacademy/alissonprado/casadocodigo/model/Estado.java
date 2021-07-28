package br.com.zupacademy.alissonprado.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"nome","pais_id"}, name = "estado_pais_uk"))
public class Estado {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String nome;

    @NotNull
    @ManyToOne
    @Column(nullable = false)
    private Pais pais;

    /**
     * Não utilizar.
     * Criado por exigencia da JPA
     */
    @Deprecated
    public Estado() {
    }

    /**
     * UniqueConstraint(nome, pais.nome)
     * @param nome
     * @param pais
     */
    public Estado(String nome, Pais pais) {
        if(nome.isBlank() || pais == null)
            throw new IllegalArgumentException("Todos os dados de Estado devem ser preenchidos.");

        this.nome = nome;
        this.pais = pais;
    }

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }
}
