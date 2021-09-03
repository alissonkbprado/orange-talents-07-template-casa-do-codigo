package br.com.zupacademy.alissonprado.casadocodigo.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AutorTest {

    @Test
    @DisplayName("Deve cadastrar autor se todos os dados forem preenchidos")
    public void deveCadastrarAutorComTodosOsDados() {
        Autor autor = new Autor("Naruto", "naruto@vila-da-folha.com", "Hokage");

        assertEquals("Naruto", autor.getNome());
        assertEquals("Hokage", autor.getDescricao());
    }

    @Test
    @DisplayName("Não deve cadastrar autor se nome for nulo")
    public void naoDeveCadastrarAutorComNomeNulo() {
        assertThrows(IllegalArgumentException.class, () -> new Autor(null, "teste@gmail.com", "teste descição."));
    }

    @Test
    @DisplayName("Não deve cadastrar autor de nome vazio")
    public void naoDeveCadastrarAutorComNomeVazio() {
        assertThrows(IllegalArgumentException.class, () -> new Autor("", "teste@gmail.com", "teste descição."));
    }

    @Test
    @DisplayName("Não deve cadastrar autor se email for nulo")
    public void naoDeveCadastrarAutorComEmailNulo() {
        assertThrows(IllegalArgumentException.class, () -> new Autor("Naruto", null, "teste descição."));
    }

    @Test
    @DisplayName("Não deve cadastrar autor se email vazio")
    public void naoDeveCadastrarAutorComEmailVazio() {
        assertThrows(IllegalArgumentException.class, () -> new Autor("Naruto", "", "teste descição."));
    }

    @Test
    @DisplayName("Não deve cadastrar autor se descricao for nulo")
    public void naoDeveCadastrarAutorComDescricaoNulo() {
        assertThrows(IllegalArgumentException.class, () -> new Autor("Naruto", null, "teste descição."));
    }

    @Test
    @DisplayName("Não deve cadastrar autor se descricao vazio")
    public void naoDeveCadastrarAutorComDescricaoVazio() {
        assertThrows(IllegalArgumentException.class, () -> new Autor("Naruto", "", "teste descição."));
    }

    @Test
    @DisplayName("Deve criar autor se id for preenchido")
    public void naoDeveCriarAutorComIdPreenchido() {
        Autor autor = new Autor(1l);
        assertNotNull(autor);
    }

    @Test
    @DisplayName("Não deve criar autor se id for nulo")
    public void naoDeveCriarAutorComIdNulo() {
        assertThrows(IllegalArgumentException.class, () -> new Autor(null));
    }

}