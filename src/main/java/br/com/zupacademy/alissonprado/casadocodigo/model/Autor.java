package br.com.zupacademy.alissonprado.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull @NotBlank @Size(min = 5, max = 250)
    private String nome;

    @NotNull @NotBlank @Email @Size(max = 250)
    private String email;

    @NotNull @NotBlank @Size(max = 400)
    @Lob
    @Column(columnDefinition = "TEXT", length = 400)
    private String descricao;

    private LocalDateTime dataCadastro = LocalDateTime.now();

    /**
     *
     * @param nome
     * @param email
     * @param descricao é obrigatório, tamanho máximo 400
     */
    public Autor(String nome, String email, String descricao) {
        if(nome.isBlank()  || email.isBlank() || descricao.isBlank()){
            throw new IllegalArgumentException("Todos os dados de Autor devem ser preenchidos.");
        }
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }
}
