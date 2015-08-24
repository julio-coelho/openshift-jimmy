package br.com.tickles.jimmy.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DRIVER")
public class Driver implements Serializable{

	private static final long serialVersionUID = -3673441154103608130L;

	@Id
	@GeneratedValue
	@Column(name="ID_DRIVER")
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="CPF")
	private Integer cpf;
	
	@Column(name="ACTIVE")
	private boolean active;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
