package br.com.cooperativa.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cooperativa.dto.VotoDTO;
import br.com.cooperativa.error.VotoException;
import br.com.cooperativa.model.Voto;
import br.com.cooperativa.repository.VotoRepository;

@Service
public class VotoService {
	private static final Logger logger = LogManager.getLogger(VotoService.class);

	@Autowired
	VotoRepository votoRepository;

	public Voto save(VotoDTO votoCadastro) {
		logger.info("Iniciando cadastro de um novo voto.");
		Voto voto = new Voto(votoCadastro.getId(), votoCadastro.getAssociado(), votoCadastro.getPauta(),
				votoCadastro.getVoto().toUpperCase());
		logger.info("Validação dos dados informados para novo voto.");
		validaVoto(voto);
		votoRepository.save(voto);
		logger.info("Voto cadastrado. Informações: " + voto);
		return voto;
	}

	public String resultadoVotacao(int idPauta) {
		int contadorSim = 0, contadorNao = 0;

		List<Voto> votos = findAllByPautaId(idPauta);

		logger.info("Navegação na lista de votos da pauta, para contagem de votos.");
		for (Voto voto : votos) {
			if (voto.getVoto().equals("S")) {
				contadorSim++;
			} else {
				contadorNao++;
			}
		}

		if (contadorSim > contadorNao) {
			logger.info("Maior número de votos 'SIM'. Total: " + contadorSim);
			return "Resultado: SIM";
		} else if (contadorNao > contadorSim) {
			logger.info("Maior número de votos 'NÃO'. Total: " + contadorNao);
			return "Resultado: NÃO";
		} else {
			logger.info("Número igual de votos 'SIM' e 'NÃO'. Resultado: EMPATE.");
			return "Resultado: EMPATE";
		}
	}

	private List<Voto> findAllByPautaId(int id) {
		logger.info("Buscando todos os votos vinculados à uma pauta. Pauta ID: " + id);
		return votoRepository.findAllByPautaId(id);
	}

	private void validaVoto(Voto voto) {
		if (!voto.getVoto().equals("S") && !voto.getVoto().equals("N")) {
			logger.error("Erro no cadastro do voto. Valor de voto inválido.");
			throw new VotoException("Voto inválido.", null);
		}

		if (voto.getVoto().isBlank() || voto.getVoto().isEmpty()) {
			logger.error("Erro no cadastro do voto. Voto nulo ou vazio.");
			throw new VotoException("Voto inválido.", null);
		}

		if (votoRepository.findByAssociadoId(voto.getAssociado().getId()).isPresent()) {
			logger.error("Erro no cadastro do voto. Associado informado já votou nesta pauta.");
			throw new VotoException("O associado com CPF: " + voto.getAssociado().getCpf() + " já votou nesta pauta.",
					null);
		}

		if (!votoRepository.findByPautaId(voto.getPauta().getId()).isPresent()) {
			logger.error("Erro no cadastro do voto. Pauta inválido ou não existe.");
			throw new VotoException("Pauta com o id: " + voto.getPauta().getId() + " é inválida.", null);
		}
	}
}