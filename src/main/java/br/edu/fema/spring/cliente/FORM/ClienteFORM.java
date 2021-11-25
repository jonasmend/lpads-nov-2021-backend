package br.edu.fema.spring.cliente.FORM;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;


public class ClienteFORM {
	
	private Integer id;
	
	@NotNull
	@Column(nullable = false)
	private String nome;
	
	@NotNull
	@Column(nullable = false)
	private Date nascimento;
	
	@NotNull
	@Column(length=14, nullable = false)
	private String cpf;
	
	@NotNull
	@Column(length=1, nullable = false)
	private char convenio;
	
	@NotNull
	@Column(length=14, nullable = false)
	private String telefone;
	
	@NotNull
	@Column(length=100, nullable = false)
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
	
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
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
