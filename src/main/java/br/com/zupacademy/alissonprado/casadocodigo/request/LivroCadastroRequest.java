package br.com.zupacademy.alissonprado.casadocodigo.request;

import br.com.zupacademy.alissonprado.casadocodigo.model.Autor;
import br.com.zupacademy.alissonprado.casadocodigo.model.Categoria;
import br.com.zupacademy.alissonprado.casadocodigo.model.Livro;
import br.com.zupacademy.alissonprado.casadocodigo.validacao.ExistId;
import br.com.zupacademy.alissonprado.casadocodigo.validacao.UniqueValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.ISBN;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroCadastroRequest {

    @NotBlank @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @NotBlank @Size(max = 500)
    private String resumo;

    private String sumario;

    @NotNull
    @DecimalMin(value = "20")
    private BigDecimal preco;

    @NotNull
    @DecimalMin(value = "100")
    private Integer paginas;

    @NotBlank
    @ISBN
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate publicacao;

    @NotNull
    @Positive
    @ExistId(domainClass = Categoria.class, message = "O id da Categoria informado não está cadatrado.")
    private Integer idCategoria;

    @NotNull
    @Positive
    @ExistId(domainClass = Autor.class,  message = "O id do Autor informado não está cadatrado.")
    private Integer idAutor;

    @JsonCreator
    public LivroCadastroRequest(String titulo, String resumo, String sumario, BigDecimal preco, Integer paginas, String isbn, LocalDate publicacao, Integer idCategoria, Integer idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.publicacao = publicacao;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }

    public Livro toModel() {

        Categoria categoria = new Categoria( Long.valueOf(idCategoria));
        Autor autor = new Autor(Long.valueOf(idAutor));

        return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.paginas, this.isbn, this.publicacao, categoria, autor);
    }
}