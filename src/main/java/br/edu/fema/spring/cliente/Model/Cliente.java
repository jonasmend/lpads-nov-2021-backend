package br.edu.fema.spring.cliente.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(nullable = false)
	private String nome;
	
	@Temporal(TemporalType.DATE)
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
	
	
	public Cliente() {
		
	}
	
	public Cliente(Integer id, String nome, Date nascimento, String cpf, char convenio, String telefone, String email) {
		this.id = id;
		this.nome = nome;
		this.nascimento = nascimento;
		this.cpf = cpf;
		this.convenio = convenio;
		this.telefone = telefone;
		this.email = email;
	}

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
