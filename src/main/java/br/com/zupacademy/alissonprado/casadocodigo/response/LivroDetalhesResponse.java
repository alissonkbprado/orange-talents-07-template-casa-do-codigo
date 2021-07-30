package br.com.zupacademy.alissonprado.casadocodigo.response;

import br.com.zupacademy.alissonprado.casadocodigo.model.Livro;

import java.time.format.DateTimeFormatter;

public class LivroDetalhesResponse {

    private String id;
    private String titulo;
    private String resumo;
    private String sumario;
    private String preco;
    private String paginas;
    private String isbn;
    private String publicacao;
    private AutorDetalhesResponse autor;

    public LivroDetalhesResponse(Livro livro) {
        this.id = livro.getId().toString();
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco().toString();
        this.paginas = livro.getPaginas().toString();
        this.isbn = livro.getIsbn();
        this.publicacao = livro.getPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString();
        this.autor = new AutorDetalhesResponse(livro.getAutor());
    }

    public String getId() {
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

    public String getPreco() {
        return preco;
    }

    public String getPaginas() {
        return paginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPublicacao() {
        return publicacao;
    }

    public AutorDetalhesResponse getAutor() {
        return autor;
    }
}