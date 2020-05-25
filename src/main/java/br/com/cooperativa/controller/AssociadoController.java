package br.com.cooperativa.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cooperativa.dto.AssociadoDTO;
import br.com.cooperativa.model.Associado;
import br.com.cooperativa.service.AssociadoService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/v1/associado")
public class AssociadoController {
	private static final Logger logger = LogManager.getLogger(AssociadoController.class);

	@Autowired
	private AssociadoService associadoService;

	@ApiOperation(value = "Cadastra novo associado.")
	@PostMapping
	public Associado cadastra(@RequestBody AssociadoDTO associado) {
		logger.info("Chamada (POST) da API para cadastrar novo associado.");
		return associadoService.save(associado);
	}
}