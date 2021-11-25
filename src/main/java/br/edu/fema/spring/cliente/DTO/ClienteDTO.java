package br.edu.fema.spring.cliente.DTO;

import java.util.Date;

import br.edu.fema.spring.cliente.Model.Cliente;

public class ClienteDTO {
	
	private Integer id;
	private String nome;
	private Date nascimento;
	private String cpf;
	private char convenio;
	private String telefone;
	private String email;
	
	public ClienteDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.nascimento = cliente.getNascimento();
		this.cpf = cliente.getCpf();
		this.convenio = cliente.getConvenio();
		this.telefone = cliente.getTelefone();
		this.email = cliente.getEmail();
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public char getConvenio() {
		return convenio;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}
	
	

}
