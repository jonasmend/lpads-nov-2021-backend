package br.edu.fema.spring.animal.DTO;

import java.util.Date;

import br.edu.fema.spring.animal.Model.Animal;
import br.edu.fema.spring.cliente.Model.Cliente;
import br.edu.fema.spring.especie.Model.Especie;

public class AnimalDTO {
	
	private Integer id;
	private Especie especie;
	private Cliente cliente;
	private String nome;
	private Date nascimento;
	
	public AnimalDTO(Animal animal) {
		this.id = animal.getId();
		this.especie = animal.getEspecie();
		this.cliente = animal.getCliente();
		this.nome = animal.getNome();
		this.nascimento = animal.getNascimento();
	}

	public Integer getId() {
		return id;
	}

	public Especie getEspecie() {
		return especie;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public String getNome() {
		return nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

}
