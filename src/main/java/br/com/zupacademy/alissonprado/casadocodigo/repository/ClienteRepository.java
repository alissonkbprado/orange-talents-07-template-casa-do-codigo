package br.com.zupacademy.alissonprado.casadocodigo.repository;

import br.com.zupacademy.alissonprado.casadocodigo.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
