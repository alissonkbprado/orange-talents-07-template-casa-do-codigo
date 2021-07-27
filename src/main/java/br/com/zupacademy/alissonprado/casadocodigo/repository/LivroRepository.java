package br.com.zupacademy.alissonprado.casadocodigo.repository;

import br.com.zupacademy.alissonprado.casadocodigo.model.Livro;
import org.springframework.data.repository.CrudRepository;

public interface LivroRepository extends CrudRepository<Livro, Long> {
}
