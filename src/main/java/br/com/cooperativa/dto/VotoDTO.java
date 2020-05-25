package br.com.cooperativa.dto;

import br.com.cooperativa.model.Associado;
import br.com.cooperativa.model.Pauta;

public class VotoDTO {
	private int id;
	private String voto;
	private Associado associado;
	private Pauta pauta;

	public VotoDTO(int id, String voto, Pauta pauta, Associado associado) {
		this.id = id;
		this.voto = voto;
		this.pauta = pauta;
		this.associado = associado;
	}

	public VotoDTO() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVoto() {
		return voto;
	}

	public void setVoto(String voto) {
		this.voto = voto;
	}

	public Associado getAssociado() {
		return associado;
	}

	public void setAssociado(Associado associado) {
		this.associado = associado;
	}

	public Pauta getPauta() {
		return pauta;
	}

	public void setPauta(Pauta pauta) {
		this.pauta = pauta;
	}
}
