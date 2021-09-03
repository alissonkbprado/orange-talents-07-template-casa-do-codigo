package br.com.zupacademy.alissonprado.casadocodigo.repository;

import br.com.zupacademy.alissonprado.casadocodigo.model.Autor;
import br.com.zupacademy.alissonprado.casadocodigo.model.Categoria;
import br.com.zupacademy.alissonprado.casadocodigo.model.Livro;
import br.com.zupacademy.alissonprado.casadocodigo.response.LivroListProjectionResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class LivroRepositoryTest {

    private static Categoria categoria;
    private static Autor autor;
    private static LocalDate dataPublicacao;

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    AutorRepository autorRepository;

    @BeforeEach
    void setUp(){
        categoria = new Categoria("Categoria");
        autor = new Autor("Alisson", "email@email.com", "Descrição");
        dataPublicacao = LocalDate.now().plusDays(10);

        categoriaRepository.save(categoria);
        autorRepository.save(autor);
    }

    @Test
    @DisplayName("Deve retornar lista de livros persistidos no banco de dados")
    void deveRetornarListaDeLivros(){
        //Adicionando livros no banco
        Livro livro1 = new Livro("Titulo",
                "Resumo",
                "Sumario",
                new BigDecimal(20.00),
                (short) 100,
                "9788575226414",
                dataPublicacao,
                categoria,
                autor);

        Livro livro2 = new Livro("Titulo 2",
                "Resumo",
                "Sumario",
                new BigDecimal(21.00),
                (short) 101,
                "9788575225882",
                dataPublicacao,
                categoria,
                autor);

        livroRepository.save(livro1);
        livroRepository.save(livro2);

        List<LivroListProjectionResponse> livroListProjectionResponses = livroRepository.findLivros();

        assertTrue(livroListProjectionResponses.size() == 2);
        assertEquals("Titulo", livroListProjectionResponses.get(0).getTitulo());
        assertEquals("Titulo 2", livroListProjectionResponses.get(1).getTitulo());
    }

    @Test
    @DisplayName("Deve retornar lista de livros persistidos no banco de dados buscando por titulo")
    void deveRetornarListaDeLivrosBuscandoPorTitulo(){
        //Adicionando livros no banco
        Livro livro1 = new Livro("Titulo",
                "Resumo",
                "Sumario",
                new BigDecimal(20.00),
                (short) 100,
                "9788575226414",
                dataPublicacao,
                categoria,
                autor);

        Livro livro2 = new Livro("Titulo 2",
                "Resumo",
                "Sumario",
                new BigDecimal(21.00),
                (short) 101,
                "9788575225882",
                dataPublicacao,
                categoria,
                autor);

        livroRepository.save(livro1);
        livroRepository.save(livro2);

        List<LivroListProjectionResponse> livroListProjectionResponses = livroRepository.findLivrosByTitulo("Titulo");

        assertTrue(livroListProjectionResponses.size() == 2);
        assertEquals("Titulo", livroListProjectionResponses.get(0).getTitulo());
        assertEquals("Titulo 2", livroListProjectionResponses.get(1).getTitulo());
    }

}