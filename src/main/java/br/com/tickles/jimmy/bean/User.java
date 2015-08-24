package br.com.tickles.jimmy.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User implements Serializable {

	private static final long serialVersionUID = 7051171783501881459L;

	@Id
	@GeneratedValue
	@Column(name = "ID_USER")
	private Integer id;
	
	@Column(name = "NOME")
	private String name;
	
	@Column(name = "SOBRENOME")
	private String sobrenome;
	
	@Column(name = "UID")
	private String uid;
	
	@Column(name = "EMAIL")
	private String email;
	
	@ManyToOne(cascade = CascadeType.REFRESH, optional=false)
	@JoinColumn(name = "ID_PROVIDER")
	private Provider provider;
	
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
	
	public String getSobrenome() {
		return sobrenome;
	}
	
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public String getUid() {
		return uid;
	}
	
	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}
}
