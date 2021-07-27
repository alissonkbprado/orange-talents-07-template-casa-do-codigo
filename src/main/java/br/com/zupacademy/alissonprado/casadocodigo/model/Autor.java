package br.com.zupacademy.alissonprado.casadocodigo.model;

import org.springframework.format.annotation.DateTimeFormat;

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

    @NotBlank @Size(min = 5, max = 250)
    @Column(nullable = false)
    private String nome;

    @NotBlank @Email @Size(max = 250)
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank @Size(max = 400)
    @Lob
    @Column(columnDefinition = "TEXT", length = 400, nullable = false)
    private String descricao;

    @DateTimeFormat
    private LocalDateTime dataCadastro = LocalDateTime.now();

    @OneToMany(mappedBy = "autor")
    private List<Livro> livros;


    /**
     *
     * @param nome NotNull
     * @param email NotNull, Unique
     * @param descricao NotNull, Max 400
     */
    public Autor(String nome, String email, String descricao) {
        if(nome.isBlank()  || email.isBlank() || descricao.isBlank()){
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
}
