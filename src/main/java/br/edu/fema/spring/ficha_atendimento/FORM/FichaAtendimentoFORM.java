package br.edu.fema.spring.ficha_atendimento.FORM;

import java.util.Date;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import br.edu.fema.spring.animal.Model.Animal;

public class FichaAtendimentoFORM {

	private Integer id;
	
	@NotNull
	private Animal animal;
	
	@NotNull
	private Date dataAtendimento;
	
	private char finalizado = 'N';
	
	private double total = 0;

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Animal getAnimal() {
		return animal;
	}
	public void setAnimalId(Animal animal) {
		this.animal = animal;
	}

	public Date getDataAtendimento() {
		return dataAtendimento;
	}
	public void setDataAtendimento(Date dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}

	public char getFinalizado() {
		return finalizado;
	}
	public void setFinalizado(char finalizado) {
		this.finalizado = finalizado;
	}

	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}
