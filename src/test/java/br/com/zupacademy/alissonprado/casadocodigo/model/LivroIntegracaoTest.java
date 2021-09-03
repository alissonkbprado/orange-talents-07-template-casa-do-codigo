package br.com.zupacademy.alissonprado.casadocodigo.model;

import br.com.zupacademy.alissonprado.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.alissonprado.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.alissonprado.casadocodigo.repository.LivroRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

import javax.validation.ConstraintViolationException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class LivroIntegracaoTest {

    private static Categoria categoria;
    private static Autor autor;
    private static LocalDate dataPublicacao;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private LivroRepository livroRepository;

    @BeforeEach
    void setUp(){
        categoria = new Categoria("Categoria");
        autor = new Autor("Alisson", "email@email.com", "Descrição");
        dataPublicacao = LocalDate.now().plusDays(10);

        categoriaRepository.save(categoria);
        autorRepository.save(autor);
    }

    @Test
    @DisplayName("Deve persistir livro com todos os dados preenchidos")
    void devePersistirComTodosOsDadosPreenchidos(){
        Livro livro = new Livro("Titulo",
                "Resumo",
                "Sumario",
                new BigDecimal(20.00),
                (short) 100,
                "9788575226414",
                dataPublicacao,
                categoria,
                autor);


        livroRepository.save(livro);

        Optional<Livro> livroPersisted = livroRepository.findById(livro.getId());

        assertTrue(livroPersisted.isPresent());
        assertEquals("Titulo", livroPersisted.get().getTitulo());
        assertEquals("Resumo", livroPersisted.get().getResumo());
        assertEquals(new BigDecimal(20.00), livroPersisted.get().getPreco());
        assertEquals((short) 100, livroPersisted.get().getPaginas());
        assertEquals(LocalDate.now().plusDays(10), livroPersisted.get().getPublicacao());
        assertNotNull(livroPersisted.get().getAutor());
    }

    @Test
    @DisplayName("Não deve persistir livro com preço menor que 20")
    void naoDevePersistirComPrecoMenorQueVinte(){
        Livro livro = new Livro("Titulo",
                "Resumo",
                "Sumario",
                new BigDecimal(19.99),
                (short) 100,
                "9788575226414",
                dataPublicacao,
                categoria,
                autor);

        assertThrows(ConstraintViolationException.class, () -> livroRepository.save(livro));
    }

    @Test
    @DisplayName("Não deve persistir livro com páginas menor que 100")
    void naoDevePersistirComPaginasMenorQueCem(){
        Livro livro = new Livro("Titulo",
                "Resumo",
                "Sumario",
                new BigDecimal(20.00),
                (short) 99,
                "9788575226414",
                dataPublicacao,
                categoria,
                autor);

        assertThrows(ConstraintViolationException.class, () -> livroRepository.save(livro));
    }

    @Test
    @DisplayName("Não deve persistir livro com ISBN inválido")
    void naoDevePersistirComIsbnInvalido(){
        Livro livro = new Livro("Titulo",
                "Resumo",
                "Sumario",
                new BigDecimal(20.00),
                (short) 100,
                "97885752264140000",
                dataPublicacao,
                categoria,
                autor);

        assertThrows(ConstraintViolationException.class, () -> livroRepository.save(livro));
    }

    @Test
    @DisplayName("Não deve persistir livro com data de publicação que não seja no futuro")
    void naoDevePersistirComDataSemSerFutura(){
        Livro livro = new Livro("Titulo",
                "Resumo",
                "Sumario",
                new BigDecimal(20.00),
                (short) 100,
                "97885752264140000",
                LocalDate.now(),
                categoria,
                autor);

        assertThrows(ConstraintViolationException.class, () -> livroRepository.save(livro));
    }

    @Test
    @DisplayName("Não deve persistir livro com Resumo maior que 500 caracteres")
    void naoDevePersistirComResmoMaiorQue500Caracteres(){
        Livro livro = new Livro("Titulo",
                "fnbcçnbçnbçnbçn bçn çfknçknf çnfg  fdghfjfdjfdghjghdfjhgjkfdgjkfdghkjhdfkjghfdjklhgjkldfhgjhdflgkjhfdlkjhglfdkhglkjhdfglkhdfkhfnbcçnbçnbçnbçn bçn çfknçknf çnfg  fdghfjfdjfdghjghdfjhgjkfdgjkfdghkjhdfkjghfdjklhgjkldfhgjhdflgkjhfdlkjhglfdkhglkjhdfglkhdfkhfnbcçnbçnbçnbçn bçn çfknçknf çnfg  fdghfjfdjfdghjghdfjhgjkfdgjkfdghkjhdfkjghfdjklhgjkldfhgjhdflgkjhfdlkjhglfdkhglkjhdfglkhdfkhfnbcçnbçnbçnbçn bçn çfknçknf çnfg  fdghfjfdjfdghjghdfjhgjkfdgjkfdghkjhdfkjghfdjklhgjkl",
                "Sumario",
                new BigDecimal(20.00),
                (short) 100,
                "97885752264140000",
                LocalDate.now(),
                categoria,
                autor);

        assertThrows(ConstraintViolationException.class, () -> livroRepository.save(livro));
    }

    @Test
    @DisplayName("Não deve persistir livro com titulo já cadsatrado")
    void naoDevePersistirLivroComTituloJaCadastrado(){
        Livro livro = new Livro("Titulo",
                "Resumo",
                "Sumario",
                new BigDecimal(20.00),
                (short) 100,
                "9788575226414",
                dataPublicacao,
                categoria,
                autor);

        livroRepository.save(livro);

        Livro livro2 = new Livro("Titulo",
                "Resumo",
                "Sumario",
                new BigDecimal(20.00),
                (short) 100,
                "9788575226414",
                dataPublicacao,
                categoria,
                autor);

        assertThrows(DataIntegrityViolationException.class, () -> livroRepository.save(livro2));
    }

    @Test
    @DisplayName("Não deve persistir livro com ISBN já cadsatrado")
    void naoDevePersistirLivroComISBNJaCadastrado(){
        Livro livro = new Livro("Titulo",
                "Resumo",
                "Sumario",
                new BigDecimal(20.00),
                (short) 100,
                "9788575226414",
                dataPublicacao,
                categoria,
                autor);

        livroRepository.save(livro);

        Livro livro2 = new Livro("Titulo2",
                "Resumo",
                "Sumario",
                new BigDecimal(20.00),
                (short) 100,
                "9788575226414",
                dataPublicacao,
                categoria,
                autor);

        assertThrows(DataIntegrityViolationException.class, () -> livroRepository.save(livro2));
    }

}