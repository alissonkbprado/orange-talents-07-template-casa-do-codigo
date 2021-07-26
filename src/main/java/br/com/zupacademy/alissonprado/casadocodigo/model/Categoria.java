package br.com.zupacademy.alissonprado.casadocodigo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Categoria {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull @NotBlank
    private String nome;

    /**
     *
     * @param nome tem que ser único
     */
    public Categoria(String nome) {
        if(nome.isBlank())
            throw new IllegalArgumentException("Todos os dados de Categoria devem ser preenchidos.");

        this.nome = nome;
    }
}
