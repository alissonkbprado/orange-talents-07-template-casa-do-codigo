package br.com.zupacademy.alissonprado.casadocodigo.model;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EnderecoTest {

    private static Pais pais;
    private static Estado estado;

    @BeforeAll
    static void setUp(){
        pais = new Pais("Pais do fogo");
        estado = new Estado("PR", pais);
    }

    @Test
    @DisplayName("Deve criar Endereço com todos os dados preenchidos")
    void deveCriarEnderecoComTodoOsDados(){
        Endereco endereco = new Endereco("Rua 1",
                "Bloco 2",
                "Vila da folha",
                12345,
                pais,
                estado);

        assertNotNull(endereco);
    }

    @Test
    @DisplayName("Não deve criar Endereço com logradouro vazio")
    void naoDeveCriarEnderecoComLogradouroVazio(){
        assertThrows(IllegalArgumentException.class, () -> new Endereco("",
                "Bloco 2",
                "Vila da folha",
                12345,
                pais,
                estado));
    }

    @Test
    @DisplayName("Não deve criar Endereço com logradouro nulo")
    void naoDeveCriarEnderecoComLogradouroNulo(){
        assertThrows(NullPointerException.class, () -> new Endereco(null,
                "Bloco 2",
                "Vila da folha",
                12345,
                pais,
                estado));
    }

    @Test
    @DisplayName("Não deve criar Endereço com comlemento vazio")
    void naoDeveCriarEnderecoComComplementoVazio(){
        assertThrows(IllegalArgumentException.class, () -> new Endereco("Rua 1",
                " ",
                "Vila da folha",
                12345,
                pais,
                estado));
    }

    @Test
    @DisplayName("Não deve criar Endereço com comlemento nulo")
    void naoDeveCriarEnderecoComComplementoNulo(){
        assertThrows(NullPointerException.class, () -> new Endereco("Rua 1",
                null,
                "Vila da folha",
                12345,
                pais,
                estado));
    }

    @Test
    @DisplayName("Não deve criar Endereço com Cidade vazio")
    void naoDeveCriarEnderecoComCidadeVazio(){
        assertThrows(IllegalArgumentException.class, () -> new Endereco("Rua 1",
                "Bloco 2",
                " ",
                12345,
                pais,
                estado));
    }

    @Test
    @DisplayName("Não deve criar Endereço com Cidade nulo")
    void naoDeveCriarEnderecoComCidadeNulo(){
        assertThrows(NullPointerException.class, () -> new Endereco("Rua 1",
                "Bloco 2",
                null,
                12345,
                pais,
                estado));
    }

    @Test
    @DisplayName("Não deve criar Endereço com CEP nulo")
    void naoDeveCriarEnderecoComCepNulo(){
        assertThrows(IllegalArgumentException.class, () -> new Endereco("Rua 1",
                "Bloco 2",
                "Vila da folha",
                null,
                pais,
                estado));
    }

    @Test
    @DisplayName("Não deve criar Endereço com Pais nulo")
    void naoDeveCriarEnderecoComPaisNulo(){
        assertThrows(IllegalArgumentException.class, () -> new Endereco("Rua 1",
                "Bloco 2",
                "Vila da folha",
                0123456,
                null,
                estado));
    }

    @Test
    @DisplayName("COnsegue criar Endereço com Estado nulo")
    void podeCriarEnderecoComEstadoNulo(){
        Endereco endereco = new Endereco("Rua 1",
                "Bloco 2",
                "Vila da folha",
                0123456,
                pais,
                null);

        assertNotNull(endereco);
    }


}