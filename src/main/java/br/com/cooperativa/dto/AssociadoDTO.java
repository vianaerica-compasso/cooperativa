package br.com.cooperativa.dto;

public class AssociadoDTO {

	private int id;
	private String cpf;

	public AssociadoDTO(int id, String cpf) {
		this.id = id;
		this.cpf = cpf;
	}

	public AssociadoDTO() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}