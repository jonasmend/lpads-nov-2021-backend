package br.edu.fema.spring.animal.FORM;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import br.edu.fema.spring.cliente.Model.Cliente;
import br.edu.fema.spring.especie.Model.Especie;

public class AnimalFORM {
	
	private Integer id;
	
	@NotNull
	private Especie especie;
	
	@NotNull
	// private Integer clienteId;
	private Cliente cliente;
	
	@NotNull
	@Column(nullable = false)
	private String nome;
	
	@NotNull
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date nascimento;

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Especie getEspecie() {
		return especie;
	}
	public void setEspecie(Especie especie) {
		this.especie = especie;
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

	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

}
