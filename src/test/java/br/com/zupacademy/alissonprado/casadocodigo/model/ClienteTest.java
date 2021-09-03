package br.com.zupacademy.alissonprado.casadocodigo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ClienteTest {

    private Endereco endereco;

    @BeforeEach
    void setUp(){
        Pais pais = new Pais("Pais do fogo");
        Estado estado = new Estado("PR", pais);

        this.endereco = new Endereco("Rua 1",
                "Bloco 2",
                "Vila da folha",
                12345,
                pais,
                estado);
    }

    @Test
    @DisplayName("Deve cadastrar Cliente com todos os dados.")
    void deveCadastrarClienteComTodosOsDados() {
        Cliente cliente = new Cliente("Naruto",
                "naruto@folha.com",
                "12345",
                "12345",
                this.endereco);

        assertNotNull(cliente);
    }

    @Test
    @DisplayName("Não deve cadastrar Cliente se o nome estiver em branco.")
    void naoDeveCadastrarClienteComNomeEmBranco() {
        assertThrows(IllegalArgumentException.class, () -> new Cliente(" ",
                "naruto@folha.com",
                "12345",
                "12345",
                endereco));
    }
    @Test
    @DisplayName("Não deve cadastrar Cliente se o nome estiver nulo.")
    void naoDeveCadastrarClienteComNomeNulo() {
        assertThrows(NullPointerException.class, () -> new Cliente(null,
                "naruto@folha.com",
                "12345",
                "12345",
                endereco));
    }

    @Test
    @DisplayName("Não deve cadastrar Cliente se o email estiver em branco.")
    void naoDeveCadastrarClienteComEmailEmBranco() {
        assertThrows(IllegalArgumentException.class, () -> new Cliente("Naruto",
                " ",
                "12345",
                "12345",
                endereco));
    }
    @Test
    @DisplayName("Não deve cadastrar Cliente se o email estiver nulo.")
    void naoDeveCadastrarClienteComEmailNulo() {
        assertThrows(NullPointerException.class, () -> new Cliente("Naruto",
                null,
                "12345",
                "12345",
                endereco));
    }

    @Test
    @DisplayName("Não deve cadastrar Cliente se o documento estiver em branco.")
    void naoDeveCadastrarClienteComDocumentoEmBranco() {
        assertThrows(IllegalArgumentException.class, () -> new Cliente("Naruto",
                "naruto@folha.com",
                " ",
                "12345",
                endereco));
    }
    @Test
    @DisplayName("Não deve cadastrar Cliente se o email estiver nulo.")
    void naoDeveCadastrarClienteComDocumentolNulo() {
        assertThrows(NullPointerException.class, () -> new Cliente("Naruto",
                "naruto@folha.com",
                null,
                "12345",
                endereco));
    }
    @Test
    @DisplayName("Não deve cadastrar Cliente se o telefone estiver em branco.")
    void naoDeveCadastrarClienteComTelefoneEmBranco() {
        assertThrows(IllegalArgumentException.class, () -> new Cliente("Naruto",
                "naruto@folha.com",
                "12345",
                " ",
                endereco));
    }

    @Test
    @DisplayName("Não deve cadastrar Cliente se o telefone estiver nulo.")
    void naoDeveCadastrarClienteComTelefoneNulo() {
        assertThrows(NullPointerException.class, () -> new Cliente("Naruto",
                "naruto@folha.com",
                "12345",
                null,
                endereco));
    }

    @Test
    @DisplayName("Não deve cadastrar Cliente se o Endereco estiver nulo.")
    void naoDeveCadastrarClienteComENderecoNulo() {
        assertThrows(NullPointerException.class, () -> new Cliente("Naruto",
                "naruto@folha.com",
                "12345",
                null,
                null));
    }

}