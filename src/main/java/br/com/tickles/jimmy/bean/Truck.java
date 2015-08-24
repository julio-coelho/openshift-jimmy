package br.com.tickles.jimmy.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRUCK")
public class Truck implements Serializable {

	private static final long serialVersionUID = 5654255377638852124L;
	
	@Id
	@GeneratedValue
	@Column(name = "ID_TRUCK")
	private Integer id;

	@Column(name = "PLACA")
	private String placa;

	@Column(name = "FROTA")
	private Integer frota;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Integer getFrota() {
		return frota;
	}

	public void setFrota(Integer frota) {
		this.frota = frota;
	}

}
