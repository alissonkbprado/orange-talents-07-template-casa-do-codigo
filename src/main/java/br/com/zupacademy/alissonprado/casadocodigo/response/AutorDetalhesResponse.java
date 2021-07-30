package br.com.zupacademy.alissonprado.casadocodigo.response;

import br.com.zupacademy.alissonprado.casadocodigo.model.Autor;

public class AutorDetalhesResponse {

    private String nomeAutor;
    private String descricaoAutor;

    public AutorDetalhesResponse(Autor autor) {
        this.nomeAutor = autor.getNome();
        this.descricaoAutor = autor.getDescricao();
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public String getDescricaoAutor() {
        return descricaoAutor;
    }
}
