package br.com.cooperativa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Voto {

	@ApiModelProperty(value = "ID do Voto")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ApiModelProperty(value = "Voto (SIM/NÃO)")
	private String voto; // sim: S / não: N

	@ApiModelProperty(value = "Associado vinculado ao voto")
	@OneToOne
	private Associado associado;
	@ApiModelProperty(value = "Pauta vinculada ao voto")
	@ManyToOne
	@JoinColumn(name = "pauta_id")
	private Pauta pauta;

	public Voto(int id, Associado associado, Pauta pauta, String voto) {
		this.id = id;
		this.voto = voto;
		this.associado = associado;
		this.pauta = pauta;
	}

	public Voto() {
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
}
