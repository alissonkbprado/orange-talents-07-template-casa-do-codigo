package br.com.zupacademy.alissonprado.casadocodigo.model;


import br.com.zupacademy.alissonprado.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.alissonprado.casadocodigo.repository.PaisRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class EstadoIntegracaoTest {

    private Pais pais;
    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private PaisRepository paisRepository;

    @BeforeEach
    void setUp(){

        this.pais = new Pais("Pais do Fogo");
        paisRepository.save(pais);
    }

    @Test
    @DisplayName("Deve persistir Estado")
    void deveCriarPersistirEstadoComTodosOsDados(){

        Estado estado = new Estado("Folha", this.pais);

        estadoRepository.save(estado);

        Optional<Estado> estadoPersisted = estadoRepository.findById(estado.getId());

        assertTrue(estadoPersisted.isPresent());
        assertEquals("Folha", estadoPersisted.get().getNome());
        assertEquals(this.pais, estadoPersisted.get().getPais());
    }

    @Test
    @DisplayName("Não deve persistir Estado se Pais não existe")
    void deveCriarPersistirEstadoSePaisNaoExiste(){
        Pais paisFalso = new Pais("Pais do Fogo");

        Estado estado = new Estado("Folha", paisFalso);

        assertThrows(DataIntegrityViolationException.class, () -> estadoRepository.save(estado));
    }
}