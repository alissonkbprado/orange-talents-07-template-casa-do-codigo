package br.com.zupacademy.alissonprado.casadocodigo.model;

import br.com.zupacademy.alissonprado.casadocodigo.repository.AutorRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class AutorIntegracaoTest {

    @Autowired
    AutorRepository autorRepository;

    @Test
    @DisplayName("Deve gravar autor no banco de dados")
    public void deveGravarAutorNoBanco(){

        Autor autor = new Autor("Alisson", "alisson.prado@teste.com", "Teste descrição");

        autorRepository.save(autor);

        Optional<Autor> autorPersistido = autorRepository.findById(autor.getId());

        List<Autor> autorList = (List<Autor>) autorRepository.findAll();

        autorList.forEach(a -> System.out.println("######################Autor: " +  a.getId() + " - " + a.getNome()));

        assertTrue(autorPersistido.isPresent());
        assertEquals("Alisson", autorPersistido.get().getNome());
        assertEquals("Teste descrição", autorPersistido.get().getDescricao());
    }

    @Test
    @DisplayName("Deve gravar autor com nome menor que 5 caracteres")
    public void naoDeveGravarAutorComNomeMenorQueCincoCaracteres(){

        Autor autor = new Autor("Alis", "naruto@teste.com", "Teste descrição");

        assertThrows(ConstraintViolationException.class, () -> autorRepository.save(autor));
    }

    @Test
    @DisplayName("Deve gravar autor com descrição maior que 400 caracteres")
    public void naoDeveGravarAutorComDescricaoMaiorQue400Caracteres(){

        Autor autor = new Autor("Alissson",
                "naruto@teste.com",
                "a55555555556666666666777777777lfdkhglkjhdfglkhdfkhfnbcçnbçnbçnbçnbçnçfknçknfçnfgfdghfjfdjfdghjghdfjhgjkfdgjkfdghkjhdfkjghfdjklhgjkldfhgjhdflgkjhfdlkjhglfdkhglkjhdfglkhdfkhfnbcçnbçnbçnbçnbçnçfknçknfçnfgfdghfjfdjfdghjghdfjhgjkfdgjkfdghkjhdfkjghfdjklhgjkldfhgjhdflgkjhfdlkjhglfdkhglkjhdfglkkjljljçklhlkhldgdfgfdggfddfdfhgfdhfdhfdhfdjytjtyjtyjdtyjtydyjtyjtyjtyjtyjtydjtydjytjytjtyjytdjydjtyjdyjyjdyjdtyjyd");

        assertThrows(ConstraintViolationException.class, () -> autorRepository.save(autor));
    }


//    @Test
//    @DisplayName("Não deve gravar autor cm email já cadastrado")
//    public void naoDeveGravarAutorComEmailJaCadastrado(){
//
//        Autor autor = new Autor("Naruto", "naruto@teste.com", "Teste descrição");
//
//        autorRepository.save(autor);
//
//        Autor autorNovo = new Autor("Sasuke", "naruto@teste.com", "Teste descrição");
//
//        assertThrows(DataIntegrityViolationException.class, () -> autorRepository.save(autorNovo));
//    }

}
