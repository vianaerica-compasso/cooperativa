package br.com.cooperativa.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.cooperativa.model.Associado;

@Repository
public interface AssociadoRepository extends CrudRepository<Associado, Integer> {

	Optional<Associado> findByCpf(String cpf);
}
