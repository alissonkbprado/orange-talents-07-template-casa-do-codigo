package br.com.zupacademy.alissonprado.casadocodigo.controller;

import br.com.zupacademy.alissonprado.casadocodigo.model.Autor;
import br.com.zupacademy.alissonprado.casadocodigo.repository.AutorRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@AutoConfigureMockMvc
class AutoresControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AutorRepository autorRepository;

    @Test
    @DisplayName("Deve retornar status 200 e cadastrar autor no banco via requisição POST")
    void deveRetornar200ECadatrarNoBancoAutorViaRequisicaoPost() throws Exception {
        URI uri = new URI("http://localhost:8080/autores");
        String json = "{\"nome\":\"Naruto\",\"email\":\"naruto@email.com\",\"descricao\":\"Teste descricao\"}";

        //simula a requisição
        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));

        Optional<Autor> autorOptional = autorRepository.findById(1L);

        assertTrue(autorOptional.isPresent());
        assertEquals("Naruto", autorOptional.get().getNome());
        assertEquals("Teste descricao", autorOptional.get().getDescricao());
    }

    @Test
    @DisplayName("Deve retornar status 400 ao tentar cadastrar autor via requisição POST com dados incorretos")
    void deveRetornarStatus400AoTentarCadatrarAutorViaRequisicaoPostComDadosIncorretos() throws Exception {
        URI uri = new URI("http://localhost:8080/autores");
        String json = "{\"nome\":\"Naruto\",\"email\":\"narutoemail.com\",\"descricao\":\"Teste descricao\"}";

        //simula a requisição
        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }



}