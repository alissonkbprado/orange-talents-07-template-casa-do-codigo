package br.com.zupacademy.alissonprado.casadocodigo.model;

import org.hibernate.validator.constraints.ISBN;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true, nullable = false)
    private String titulo;

    @NotBlank @Size(max = 500)
    @Column(columnDefinition = "TEXT", length = 500, nullable = false)
    private String resumo;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String sumario;

    @NotNull
    @DecimalMin(value = "20")
    @Column(nullable = false)
    private BigDecimal preco;

    @NotNull
    @DecimalMin(value = "100")
    @Column(nullable = false)
    private Short paginas;

    @NotBlank
    @ISBN
    @Column(unique = true, nullable = false)
    private String isbn;

    @Future
    @DateTimeFormat
    private LocalDate publicacao;

    @NotNull
    @ManyToOne
    private Categoria categoria;

    @NotNull
    @ManyToOne
    private Autor autor;

    /**
     * Não utilizar.
     * Criado por exigencia da JPA
     */
    @Deprecated
    public Livro() {
    }

    /**
     *
     * @param titulo NotNull, Unique
     * @param resumo NotNull, Max 500
     * @param preco NotNull, Min 20
     * @param paginas NotNull, Min 100
     * @param isbn NotNull, Unique
     * @param categoria NotNull
     * @param autor NotNull
     */
    public Livro(String titulo, String resumo, BigDecimal preco, Short paginas, String isbn, Categoria categoria, Autor autor) {
        if(titulo.isBlank() || resumo.isBlank() || preco == null || paginas == null || isbn.isBlank() || categoria == null || autor == null)
            throw new IllegalArgumentException("Todos os dados de Livro devem ser preenchidos.");
        this.titulo = titulo;
        this.resumo = resumo;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.categoria = categoria;
        this.autor = autor;
    }

    /**
     *
     * @param titulo NotNull, Unique
     * @param resumo NotNull, Max 500
     * @param sumario
     * @param preco NotNull, Min 20
     * @param paginas NotNull, Min 100
     * @param isbn NotNull, Unique
     * @param publicacao @Future
     * @param categoria NotNull
     * @param autor NotNull
     */
    public Livro(String titulo, String resumo, String sumario, BigDecimal preco, Short paginas, String isbn, LocalDate publicacao, Categoria categoria, Autor autor) {
        if(titulo.isBlank() || resumo.isBlank() || preco == null || paginas == null || isbn.isBlank() || categoria == null || autor == null)
            throw new IllegalArgumentException("Os atributos (titulo, resumo, preco, paginas, isbn, categoria, autor) são obrigatórios.");
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.publicacao = publicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Short getPaginas() {
        return paginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getPublicacao() {
        return publicacao;
    }

    public Autor getAutor() {
        return autor;
    }
}
