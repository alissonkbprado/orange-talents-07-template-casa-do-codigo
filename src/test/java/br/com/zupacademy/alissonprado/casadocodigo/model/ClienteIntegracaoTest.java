package br.com.zupacademy.alissonprado.casadocodigo.model;

import br.com.zupacademy.alissonprado.casadocodigo.repository.ClienteRepository;
import br.com.zupacademy.alissonprado.casadocodigo.repository.PaisRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

import javax.validation.ConstraintViolationException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ClienteIntegracaoTest {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PaisRepository paisRepository;

    private Endereco endereco;

    @BeforeEach
    void setUp(){
        Pais pais = new Pais("Pais do fogo");
        Estado estado = new Estado("PR", pais);

        paisRepository.save(pais);

        this.endereco = new Endereco("Rua 1",
                "Bloco 2",
                "Vila da folha",
                12345,
                pais,
                estado);
    }


    @Test
    @DisplayName("Deve gravar Cliente com todos os dados no banco.")
    public void deveCadastrarClienteNoBanco() {
        Cliente cliente = new Cliente("Naruto",
                "naruto@folha.com",
                "81424440033",
                "12345",
                endereco);

        clienteRepository.save(cliente);

        Optional<Cliente> clienteSaved = clienteRepository.findById(cliente.getId());

        assertTrue(clienteSaved.isPresent());
        assertEquals(cliente.getId(), clienteSaved.get().getId());
    }

    @Test
    @DisplayName("Não deve gravar no banco  Cliente com documento incorreto.")
    public void naoDeveCadastrarClienteNoBancoComDocumentoInvalido() {
        Cliente cliente = new Cliente("Naruto",
                "naruto@folha.com",
                "00000000000",
                "12345",
                endereco);

        Cliente cliente2 = new Cliente("Naruto",
                "naruto2@folha.com",
                "123",
                "12345",
                endereco);

        assertThrows(ConstraintViolationException.class, () -> clienteRepository.save(cliente));
        assertThrows(ConstraintViolationException.class, () -> clienteRepository.save(cliente2));
    }

    @Test
    @DisplayName("Não deve gravar no banco  Cliente com email já cadsatrado.")
    public void naoDeveCadastrarClienteNoBancoComEmailJaCadastrado() {
        Cliente cliente = new Cliente("Naruto",
                "naruto@folha.com",
                "96905015008",
                "12345",
                endereco);

        Cliente cliente2 = new Cliente("Sasuke",
                "naruto@folha.com",
                "77632521038",
                "12345",
                endereco);

        clienteRepository.save(cliente);

        assertThrows(DataIntegrityViolationException.class, () -> clienteRepository.save(cliente2));
    }

    @Test
    @DisplayName("Não deve gravar no banco  Cliente com documento já cadsatrado.")
    public void naoDeveCadastrarClienteNoBancoComDocumentoJaCadastrado() {
        Cliente cliente = new Cliente("Naruto",
                "naruto@folha.com",
                "96905015008",
                "12345",
                endereco);

        Cliente cliente2 = new Cliente("Sasuke",
                "sauke@folha.com",
                "96905015008",
                "12345",
                endereco);

        clienteRepository.save(cliente);

        assertThrows(DataIntegrityViolationException.class, () -> clienteRepository.save(cliente2));
    }

    @Test
    @DisplayName("Não deve gravar no banco  Cliente com email inválido.")
    public void naoDeveCadastrarClienteNoBancoComEmailInvalido() {
        Cliente cliente = new Cliente("Naruto",
                "naruto@",
                "96905015008",
                "12345",
                endereco);

        assertThrows(ConstraintViolationException.class, () -> clienteRepository.save(cliente));
    }
}