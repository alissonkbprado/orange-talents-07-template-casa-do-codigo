package br.com.zupacademy.alissonprado.casadocodigo.model;

import br.com.zupacademy.alissonprado.casadocodigo.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Entity
public class Endereco {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String logradouro;

    @NotBlank
    @Column(nullable = false)
    private String complemento;

    @NotBlank
    @Column(nullable = false)
    private String cidade;

    @NotNull
    @Column(nullable = false)
    private Integer cep;

    @NotNull
    @ManyToOne
    private Pais pais;

    @ManyToOne
    private Estado estado;

    /**
     * Não utilizar.
     * Criado por exigencia da JPA
     */
    @Deprecated
    public Endereco() {
    }

    /**
     *
     * @param logradouro NotNull
     * @param complemento NotNull
     * @param cidade NotNull
     * @param cep NotNull, Number
     * @param pais NotNull
     */
    public Endereco(String logradouro, String complemento, String cidade, Integer cep, Pais pais) {
        if(logradouro.isBlank() || complemento.isBlank() || cidade.isBlank() || cep == null || pais == null)
            throw new IllegalArgumentException("Todos os dados obrigatórios de Endereço devem ser preenchidos.");
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.cidade = cidade;
        this.cep = cep;
        this.pais = pais;
        this.estado = estado;
    }

    /**
     *
     * @param logradouro NotNull
     * @param complemento NotNull
     * @param cidade NotNull
     * @param cep NotNull
     * @param pais NotNull
     * @param estado Regra: Só pode cadastrar Estado se estiver na tabela e relacionado com o pais
     */
    public Endereco(String logradouro, String complemento, String cidade, Integer cep, Pais pais, Estado estado) {
        if(logradouro.isBlank() || complemento.isBlank() || cidade.isBlank() || cep == null || pais == null)
            throw new IllegalArgumentException("Todos os dados obrigatórios de Endereço devem ser preenchidos.");
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.cidade = cidade;
        this.cep = cep;
        this.pais = pais;
        this.estado = estado;
    }
}
