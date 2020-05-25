package br.com.cooperativa.dto;

public class PautaDTO {

	private int id;
	private String descricao;

	public PautaDTO(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public PautaDTO() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
