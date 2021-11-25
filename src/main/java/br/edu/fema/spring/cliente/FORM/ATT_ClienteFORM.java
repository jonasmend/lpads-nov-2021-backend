package br.edu.fema.spring.cliente.FORM;

import javax.persistence.Column;

import com.sun.istack.NotNull;

public class ATT_ClienteFORM {
	
	private Integer id;
	
	
	private String nome;
	
	@Column(length=1)
	private char convenio;
	
	@Column(length=14)
	private String telefone;
	
	@Column(length=100)
	private String email;
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public char getConvenio() {
		return convenio;
	}
	public void setConvenio(char convenio) {
		this.convenio = convenio;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
