package br.edu.fema.spring.animal.FORM;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import br.edu.fema.spring.cliente.Model.Cliente;

public class ATT_AnimalFORM {
	
	private Integer id;
	
	@NotNull
	private Cliente cliente;
	
	@NotNull
	@Column(nullable = false)
	private String nome;

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
