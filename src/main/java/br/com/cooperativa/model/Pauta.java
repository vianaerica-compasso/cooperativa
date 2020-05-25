package br.com.cooperativa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Pauta {

	@ApiModelProperty(value = "ID da Pauta")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ApiModelProperty(value = "Descrição da pauta")
	private String descricao;

	public Pauta(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Pauta() {
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
