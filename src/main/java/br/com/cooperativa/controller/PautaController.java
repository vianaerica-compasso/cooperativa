package br.com.cooperativa.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cooperativa.dto.PautaDTO;
import br.com.cooperativa.model.Pauta;
import br.com.cooperativa.service.PautaService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/v1/pauta")
public class PautaController {
	private static final Logger logger = LogManager.getLogger(PautaController.class);

	@Autowired
	private PautaService pautaService;

	@ApiOperation(value = "Cadastra nova pauta.")
	@PostMapping
	public Pauta cadastra(@RequestBody PautaDTO pauta) {
		logger.info("Chamada (POST) da API para cadastrar nova pauta.");
		return pautaService.save(pauta);
	}
}
