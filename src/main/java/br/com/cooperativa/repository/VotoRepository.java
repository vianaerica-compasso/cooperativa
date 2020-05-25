package br.com.cooperativa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.cooperativa.model.Voto;

@Repository
public interface VotoRepository extends CrudRepository<Voto, Integer> {
	List<Voto> findAllByPautaId(int id);

	Optional<Voto> findByAssociadoId(int id);

	Optional<Voto> findByPautaId(int id);
}
