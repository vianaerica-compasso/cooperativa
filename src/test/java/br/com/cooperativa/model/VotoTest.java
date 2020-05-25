package br.com.cooperativa.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VotoTest {

	Associado associado = new Associado(7, "41733876014");
	Pauta pauta = new Pauta(2, "Votação 2");
	Voto voto = new Voto(1, associado, pauta, "S");

	@Test
	public void retornaIdVoto() {
		assertEquals(1, voto.getId());
	}

	@Test
	public void retornaVoto() {
		assertEquals("S", voto.getVoto());
	}

	@Test
	public void retornaIdAssociadoVinculadoAoVoto() {
		assertEquals(7, voto.getAssociado().getId());
	}

	@Test
	public void retornaIdPautaVinculadaAoVoto() {
		assertEquals(2, voto.getPauta().getId());
	}

	@Test
	public void retornaCpfAssociadoVinculadoAoVoto() {
		assertEquals("41733876014", voto.getAssociado().getCpf());
	}

	@Test
	public void retornaDescricaoPautaVinculadaAoVoto() {
		assertEquals("Votação 2", voto.getPauta().getDescricao());
	}
}
