package br.com.zupacademy.alissonprado.casadocodigo.model;

import br.com.zupacademy.alissonprado.casadocodigo.repository.CategoriaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CategoriaIntegracaoTest {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Test
    @DisplayName("Deve cadastrar categoria no banco de dados")
    public void deveCadastrarCategoriaNoBancoDeDados(){
        Categoria categoria = new Categoria("Jonin");
        categoriaRepository.save(categoria);
        Optional<Categoria> categoriaPersistida = categoriaRepository.findById(categoria.getId());

        assertNotNull(categoriaPersistida.get());
    }
}