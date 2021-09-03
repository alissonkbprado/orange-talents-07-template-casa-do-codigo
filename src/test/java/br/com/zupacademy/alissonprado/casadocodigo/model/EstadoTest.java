package br.com.zupacademy.alissonprado.casadocodigo.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstadoTest {

    private Pais pais;

    @BeforeEach
    void setUp(){
        this.pais = new Pais("Pais do Fogo");
    }

    @Test
    @DisplayName("Deve criar Estado")
    void deveCriarEstadoComTodosOsDados(){
        Estado estado = new Estado("Folha", this.pais);

        assertNotNull(estado);
        assertEquals("Folha", estado.getNome());
        assertEquals(this.pais, estado.getPais());
    }

    @Test
    @DisplayName("Não deve criar Estado se nome está vazio")
    void naoDeveCriarEstadoComNomeVazio(){
        assertThrows(IllegalArgumentException.class, () -> new Estado(" ", this.pais));
    }

    @Test
    @DisplayName("Não deve criar Estado se Pais está nulo")
    void naoDeveCriarEstadoComPaisNulo(){
        assertThrows(IllegalArgumentException.class, () -> new Estado("Folha", null));
    }

    @Test
    @DisplayName("Deve retornar TRUE se percence ao Pais")
    void deveRetornarTrueSePertenceAoPais(){
        Pais pais = new Pais("Brasil");

        Estado estado = new Estado("Paraná", pais);

        Pais paisComparacao = new Pais("Brasil");

        assertTrue(estado.pertenceAPais(paisComparacao));
    }

    @Test
    @DisplayName("Deve retornar False se não percence ao Pais")
    void deveRetornarFalseSeNaoPertenceAoPais(){
        Pais pais = new Pais("Brasil");

        Estado estado = new Estado("Paraná", pais);

        Pais paisComparacao = new Pais("Japão");

        assertFalse(estado.pertenceAPais(paisComparacao));
    }
}