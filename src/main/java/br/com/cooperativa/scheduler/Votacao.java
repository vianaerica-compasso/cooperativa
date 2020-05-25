package br.com.cooperativa.scheduler;

import java.util.Timer;
import java.util.TimerTask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Votacao extends TimerTask {
	private static final Logger logger = LogManager.getLogger(Votacao.class);

	public void run(Timer timer) {
		System.out.println("FIM DA VOTAÇÃO");
		logger.info("Encerrando tempo de sessão de votação.");
		timer.cancel();
	}

	@Override
	public void run() {
	}
}
