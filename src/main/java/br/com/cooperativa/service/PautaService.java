package br.com.cooperativa.service;

import java.util.Timer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cooperativa.dto.PautaDTO;
import br.com.cooperativa.model.Pauta;
import br.com.cooperativa.repository.PautaRepository;
import br.com.cooperativa.scheduler.Votacao;

@Service
public class PautaService {
	private static final Logger logger = LogManager.getLogger(PautaService.class);

	@Autowired
	PautaRepository pautaRepository;

	public Pauta save(PautaDTO pautaCadastro) {
		logger.info("Iniciando cadastro de uma nova pauta.");
		Pauta pauta = new Pauta(pautaCadastro.getId(), pautaCadastro.getDescricao());
		pautaRepository.save(pauta);
		logger.info("Pauta cadastrada. Informações: " + pauta);
		logger.info("Iniciando contagem do tempo de sessão de votação.");
		iniciaSessao(1);
		return pauta;
	}

	private void iniciaSessao(int segundos) {
		Timer timer = new Timer();
		logger.info("Iniciando contagem do tempo de sessão de votação. Após 1 minuto, a contagem irá se encerrar.");
		timer.schedule(new Votacao(), segundos * 1000);
	}
}
