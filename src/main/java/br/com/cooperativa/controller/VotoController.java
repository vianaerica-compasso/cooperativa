package br.com.cooperativa.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cooperativa.dto.VotoDTO;
import br.com.cooperativa.model.Voto;
import br.com.cooperativa.service.VotoService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/v1/voto")
public class VotoController {
	private static final Logger logger = LogManager.getLogger(VotoController.class);

	@Autowired
	private VotoService votoService;

	@ApiOperation(value = "Cadastra novo voto.")
	@PostMapping
	public Voto cadastra(@RequestBody VotoDTO voto) {
		logger.info("Chamada (POST) da API para cadastrar novo voto.");
		return votoService.save(voto);
	}

	@ApiOperation(value = "Retorna resultado da votação de uma pauta, a partir do ID informado.")
	@GetMapping("/resultado/{idPauta}")
	public String resultadoVotacao(@PathVariable int idPauta) {
		logger.info("Chamada (GET) da API para retornar o resultado da votação.");
		return votoService.resultadoVotacao(idPauta);
	}
}