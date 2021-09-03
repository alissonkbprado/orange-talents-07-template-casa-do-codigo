package br.com.zupacademy.alissonprado.casadocodigo.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Autor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Size(min = 5)
    @Column(nullable = false)
    private String nome;

    @NotBlank @Email
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank @Size(max = 400)
    @Lob
    @Column(columnDefinition = "TEXT", length = 400, nullable = false)
    private String descricao;

    @CreationTimestamp
    private LocalDateTime dataCadastro;

    @OneToMany(mappedBy = "autor")
    private List<Livro> livros;

    /**
     * Não utilizar.
     * Criado por exigencia da JPA
     */
    @Deprecated
    public Autor() {
    }

    /**
     *
     * @param nome NotNull
     * @param email NotNull, Unique
     * @param descricao NotNull, Max 400
     */
    public Autor(String nome, String email, String descricao) {
        if(nome == null  || email == null || descricao == null || nome.isBlank()  || email.isBlank() || descricao.isBlank()){
            throw new IllegalArgumentException("Todos os dados de Autor devem ser preenchidos.");
        }
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    /**
     *
     * @param id NotNull
     */
    public Autor(Long id) {
        if(id == null)
            throw new IllegalArgumentException("Campo id não pode ser nulo.");

        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Long getId() {
        return id;
    }
}
