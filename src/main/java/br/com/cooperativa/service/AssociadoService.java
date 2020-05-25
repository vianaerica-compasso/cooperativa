package br.com.cooperativa.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cooperativa.dto.AssociadoDTO;
import br.com.cooperativa.error.AssociadoException;
import br.com.cooperativa.model.Associado;
import br.com.cooperativa.repository.AssociadoRepository;

@Service
public class AssociadoService {
	private static final Logger logger = LogManager.getLogger(AssociadoService.class);

	@Autowired
	AssociadoRepository associadoRepository;

	public Associado save(AssociadoDTO associadoCadastro) {
		logger.info("Iniciando cadastro de um novo associado.");
		Associado associado = new Associado(associadoCadastro.getId(), associadoCadastro.getCpf());
		logger.info("Validação dos dados informados para novo associado.");
		validaAssociado(associado);
		associadoRepository.save(associado);
		logger.info("Associado cadastrado. Informações: " + associado);
		return associado;
	}

	private void validaAssociado(Associado associado) {
		if (associadoRepository.findByCpf(associado.getCpf()).isPresent()) {
			logger.error("Erro ao cadastrar associado. CPF já existente no banco de dados.");
			throw new AssociadoException("O associado com CPF: " + associado.getCpf() + " já está cadastrado.", null);
		}

		if (associadoRepository.findById(associado.getId()).isPresent()) {
			logger.error("Erro ao cadastrar associado. ID já existente no banco de dados.");
			throw new AssociadoException("O associado com id: " + associado.getId() + " já está cadastrado.", null);
		}
	}
}