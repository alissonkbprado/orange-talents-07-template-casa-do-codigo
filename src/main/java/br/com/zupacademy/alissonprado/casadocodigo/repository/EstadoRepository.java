package br.com.zupacademy.alissonprado.casadocodigo.repository;

import br.com.zupacademy.alissonprado.casadocodigo.model.Estado;
import org.springframework.data.repository.CrudRepository;

public interface EstadoRepository extends CrudRepository<Estado, Long> {
    Estado findByNomeAndPais_Id(String nome, long l);
}
