package br.com.zupacademy.alissonprado.casadocodigo.repository;

import br.com.zupacademy.alissonprado.casadocodigo.model.Livro;
import br.com.zupacademy.alissonprado.casadocodigo.response.LivroListProjectionResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LivroRepository extends CrudRepository<Livro, Long> {

    @Query(value = "SELECT l.id, l.titulo FROM livro l ORDER BY l.titulo ASC", nativeQuery = true)
    List<LivroListProjectionResponse> findLivros();

    @Query(value = "SELECT l.id, l.titulo FROM livro l WHERE l.titulo LIKE %:titulo% ORDER BY l.titulo ASC", nativeQuery = true)
    List<LivroListProjectionResponse> findLivrosByTitulo(String titulo);

}
