package br.com.zupacademy.alissonprado.casadocodigo.controller;

import br.com.zupacademy.alissonprado.casadocodigo.model.Estado;
import br.com.zupacademy.alissonprado.casadocodigo.model.Pais;
import br.com.zupacademy.alissonprado.casadocodigo.repository.ClienteRepository;
import br.com.zupacademy.alissonprado.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.alissonprado.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.alissonprado.casadocodigo.request.ClienteCadastroRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Test
    @DisplayName("Deve cadastrar Cliente e retornar Status 200")
    void deveCadastrarClienteERetornarStatus200() throws Exception {

        Pais pais = new Pais("Brasil");

        paisRepository.save(pais);
        estadoRepository.save(new Estado("Paraná", pais));

        ClienteCadastroRequest body = new ClienteCadastroRequest("Teste",
                "teste@zup.com",
                "00000000000",
                "41-9999-9999",
                "Rua teste",
                "Bloco 1",
                "Curitiba",
                80000000,
                "1",
                "1"
                );

        MockHttpServletRequestBuilder request = post("http://localhost:8080/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(body));

        //Simula a requisição
        mockMvc.perform(request)
                .andExpect(status().isOk());

//        mockMvc.perform(MockMvcRequestBuilders.post(uri)
//                        .content(json)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().is(200));
    }



}