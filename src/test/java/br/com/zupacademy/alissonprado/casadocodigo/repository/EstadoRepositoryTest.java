package br.com.zupacademy.alissonprado.casadocodigo.repository;

import br.com.zupacademy.alissonprado.casadocodigo.model.Estado;
import br.com.zupacademy.alissonprado.casadocodigo.model.Pais;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class EstadoRepositoryTest {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Test
    @DisplayName("Deve retornar Estado persistido no banco de dados em busca de nome e país")
    void deveRetornarEstadoPersistidoNoBancoBuscandoPorNomeEPais(){
        Pais pais = new Pais("Brasil");
        paisRepository.save(pais);

        Estado estado = new Estado("Paraná", pais);
        estadoRepository.save(estado);

        Estado estadoPersistido = estadoRepository.findByNomeAndPais_Id("Paraná", pais.getId());

        assertNotNull(estadoPersistido);
        assertEquals("Paraná", estado.getNome());
        assertEquals(pais, estado.getPais());
    }
}