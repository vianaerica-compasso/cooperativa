package br.com.cooperativa.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AssociadoTest {

	Associado associado = new Associado(7, "41733876014");

	@Test
	public void retornaIdAssociado() {
		assertEquals(7, associado.getId());
	}

	@Test
	public void retornaCpfAssociado() {
		assertEquals("41733876014", associado.getCpf());
	}
}