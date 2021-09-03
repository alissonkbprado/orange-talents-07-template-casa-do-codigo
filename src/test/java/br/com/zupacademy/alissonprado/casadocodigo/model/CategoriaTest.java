package br.com.zupacademy.alissonprado.casadocodigo.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoriaTest {

    @Test
    @DisplayName("Deve cadastrar categoria com nome preenchido")
    public void deveCadastrarCategoriaComNomePreenchido(){
        Categoria categoria = new Categoria("Jonin");
        assertNotNull(categoria);
    }

    @Test
    @DisplayName("Deve cadastrar categoria com id preenchido")
    public void deveCadastrarCategoriaComIdPreenchido(){
        Categoria categoria = new Categoria(1l);
        assertNotNull(categoria);
    }

    @Test
    @DisplayName("Não deve deixar cadastrar categoria com nome nulo")
    public void naoDeveCadastrarCategoriaComNomeNulo(){
        assertThrows(IllegalArgumentException.class, () -> new Categoria((String) null));
    }

    @Test
    @DisplayName("Não deve deixar cadastrar categoria com nome em branco")
    public void naoDeveCadastrarCategoriaComNomeEmBranco(){
        assertThrows(IllegalArgumentException.class, () -> new Categoria(" "));
    }

    @Test
    @DisplayName("Não deve deixar cadastrar categoria com id nulo")
    public void naoDeveCadastrarCategoriaComIdEmBranco(){
        assertThrows(IllegalArgumentException.class, () -> new Categoria((Long) null));
    }


}