package br.com.cooperativa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.cooperativa.model.Pauta;

@Repository
public interface PautaRepository extends CrudRepository<Pauta, Integer> {

}
