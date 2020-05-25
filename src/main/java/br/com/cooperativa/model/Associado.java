package br.com.cooperativa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Associado {

	@ApiModelProperty(value = "ID do Associado")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ApiModelProperty(value = "CPF do Associado")
	private String cpf;

	public Associado(int id, String cpf) {
		this.id = id;
		this.cpf = cpf;
	}

	public Associado() {
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