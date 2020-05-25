package br.com.cooperativa.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PautaTest {

	Pauta pauta = new Pauta(2, "Votação 2");

	@Test
	public void retornaIdPauta() {
		assertEquals(2, pauta.getId());
	}

	@Test
	public void retornaDescricaoPauta() {
		assertEquals("Votação 2", pauta.getDescricao());
	}
}
