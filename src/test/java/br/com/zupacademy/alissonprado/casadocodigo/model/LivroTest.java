package br.com.zupacademy.alissonprado.casadocodigo.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LivroTest {

    private static Categoria categoria;
    private static Autor autor;
    private static LocalDate dataPublicacao;

    @BeforeAll
    static void setUp(){
        categoria = new Categoria("Categoria");
        autor = new Autor("Nome", "email@email.com", "Descrição");
        dataPublicacao = LocalDate.of(2021, 9, 2);
    }

    @Test
    @DisplayName("Deve criar livro com todos os dados preenchidos")
    void deveCriarComTodosOsDadosPreenchidos(){
        Livro livro = new Livro("Titulo",
                "Resumo",
                "Sumario",
                new BigDecimal(12.23),
                (short) 100,
                "ISBN",
                LocalDate.now(),
                categoria,
                autor);

        assertNotNull(livro);
        assertEquals("Titulo", livro.getTitulo());
        assertEquals("Resumo", livro.getResumo());
        assertEquals(new BigDecimal(12.23), livro.getPreco());
        assertEquals((short) 100, livro.getPaginas());
        assertEquals(LocalDate.of(2021, 9, 2), livro.getPublicacao());
        assertNotNull(livro.getAutor());
    }

    @Test
    @DisplayName("Não deve criar livro com Titilo em branco")
    void naodeveCriarComTituloEmBranco(){
        Categoria categoria = new Categoria("Categoria");
        Autor autor = new Autor("Nome", "email@email.com", "Descrição");

        LocalDate localDate = LocalDate.of(2021, 9, 2);

        assertThrows(IllegalArgumentException.class, () -> new Livro(" ",
                "Resumo",
                "Sumario",
                new BigDecimal(12.23),
                (short) 100,
                "ISBN",
                LocalDate.now(),
                categoria,
                autor));
    }

    @Test
    @DisplayName("Não deve criar livro com Titilo Nulo")
    void naoDeveCriarComTituloNulo(){
        assertThrows(NullPointerException.class, () -> new Livro(null,
                "Resumo",
                "Sumario",
                new BigDecimal(12.23),
                (short) 100,
                "ISBN",
                LocalDate.now(),
                categoria,
                autor));
    }

    @Test
    @DisplayName("Não deve criar livro com Resumo em branco")
    void naodeveCriarComResumoEmBranco(){
        assertThrows(IllegalArgumentException.class, () -> new Livro("Titulo",
                " ",
                "Sumario",
                new BigDecimal(12.23),
                (short) 100,
                "ISBN",
                LocalDate.now(),
                categoria,
                autor));
    }

    @Test
    @DisplayName("Não deve criar livro com Resumo nulo")
    void naodeveCriarComResumoNulo(){
        assertThrows(NullPointerException.class, () -> new Livro("Titulo",
                null,
                "Sumario",
                new BigDecimal(12.23),
                (short) 100,
                "ISBN",
                LocalDate.now(),
                categoria,
                autor));
    }

    @Test
    @DisplayName("Permite criar livro com Sumario em branco")
    void permiteCriarComSumarioEmBranco(){
        Livro livro = new Livro("Titulo",
                "Resumo",
                " ",
                new BigDecimal(12.23),
                (short) 100,
                "ISBN",
                LocalDate.now(),
                categoria,
                autor);

        assertNotNull(livro);
    }

    @Test
    @DisplayName("Não deve criar livro com Preço nulo")
    void naoDeveCriarComPrecoNulo(){
        assertThrows(IllegalArgumentException.class, () -> new Livro("Titulo",
                "Resumo",
                "Sumario",
                null,
                (short) 100,
                "ISBN",
                LocalDate.now(),
                categoria,
                autor));
    }

    @Test
    @DisplayName("Não deve criar livro com Páginas nulo")
    void naoDeveCriarComPaginasNulo(){
        assertThrows(IllegalArgumentException.class, () -> new Livro("Titulo",
                "Resumo",
                "Sumario",
                new BigDecimal(12.23),
                null,
                "ISBN",
                LocalDate.now(),
                categoria,
                autor));
    }

    @Test
    @DisplayName("Não deve criar livro com ISBN em branco")
    void naoDeveCriarComIsbnEmBranco(){
        assertThrows(IllegalArgumentException.class, () -> new Livro("Titulo",
                "Resumo",
                "Sumario",
                new BigDecimal(12.23),
                (short) 100,
                " ",
                LocalDate.now(),
                categoria,
                autor));
    }

    @Test
    @DisplayName("Não deve criar livro com ISBN nulo")
    void naoDeveCriarComIsbnNulo(){
        assertThrows(NullPointerException.class, () -> new Livro("Titulo",
                "Resumo",
                "Sumario",
                new BigDecimal(12.23),
                (short) 100,
                null,
                LocalDate.now(),
                categoria,
                autor));
    }

    @Test
    @DisplayName("Permite criar Livro com Publicação nulo")
    void permiteCriarComPublicacaoNulo(){
        Livro livro = new Livro("Titulo",
                "Resumo",
                "Sumario",
                new BigDecimal(12.23),
                (short) 100,
                "ISBN",
                null,
                categoria,
                autor);

        assertNotNull(livro);
    }

    @Test
    @DisplayName("Não deve criar livro com Categoria nulo")
    void naoDeveCriarComCategoriaNulo(){
        assertThrows(IllegalArgumentException.class, () -> new Livro("Titulo",
                "Resumo",
                "Sumario",
                new BigDecimal(12.23),
                (short) 100,
                "ISBN",
                LocalDate.now(),
                null,
                autor));
    }

    @Test
    @DisplayName("Não deve criar livro com Autor nulo")
    void naoDeveCriarComAutorNulo(){
        assertThrows(IllegalArgumentException.class, () -> new Livro("Titulo",
                "Resumo",
                "Sumario",
                new BigDecimal(12.23),
                (short) 100,
                "ISBN",
                LocalDate.now(),
                categoria,
                null));
    }

}