package br.com.zupacademy.alissonprado.casadocodigo.controller;

import br.com.zupacademy.alissonprado.casadocodigo.model.Categoria;
import br.com.zupacademy.alissonprado.casadocodigo.repository.CategoriaRepository;
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
class CategoriasControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Test
    @DisplayName("Deve retornar status 200 ao cadastrar Categoria via requisição POST")
    void deveRetornarStatus200ECadastrarCategoriaViaRequisicaoPost() throws Exception {
        URI uri = new URI("http://localhost:8080/categorias");
        String json = "{\"nome\":\"Categoria teste\"}";

        //Simula a requisição
        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));

        Optional<Categoria> categoriaOptional = categoriaRepository.findById(1L);

        assertTrue(categoriaOptional.isPresent());
        assertEquals("Categoria teste", categoriaOptional.get().getNome());
    }

    @Test
    @DisplayName("Deve retornar status 400 ao tentar cadastrar Categoria via requisição POST com dados incorretos")
    void deveRetornarStatus400AOTentarCadastrarCategoriaViaRequisicaoPostComDadosIncorretos() throws Exception {
        URI uri = new URI("http://localhost:8080/categorias");
        String json = "{\"nome\":\"\"}";

        //Simula a requisição
        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

}