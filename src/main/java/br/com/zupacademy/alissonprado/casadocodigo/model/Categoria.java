package br.com.zupacademy.alissonprado.casadocodigo.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Categoria {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "categoria")
    private List<Livro> livros;

    /**
     * Não utilizar.
     * Criado por exigencia da JPA
     */
    @Deprecated
    public Categoria() {
    }

    /**
     *
     * @param nome NotNull, Unique
     */
    public Categoria(String nome) {
        if(nome == null || nome.isBlank())
            throw new IllegalArgumentException("Todos os dados de Categoria devem ser preenchidos.");

        this.nome = nome;
    }

    /**
     *
     * @param id NotNull
     */
    public Categoria(Long id) {
        if(id == null)
            throw new IllegalArgumentException("Campo id não pode ser nulo.");

        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
