package br.edu.fema.spring.ficha_atendimento.Model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.javamoney.moneta.Money;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.edu.fema.spring.animal.Model.Animal;

@Entity
public class FichaAtendimento {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne @NotNull
	private Animal animal;
	
	@NotNull
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataAtendimento;
	
	private char finalizado = 'N';
	
	private BigDecimal total;
	
	public FichaAtendimento() {}
	
	public FichaAtendimento(Integer id, Animal animal, Date dataAtendimento, char finalizado, BigDecimal total) {
		this.id = id;
		this.animal = animal;
		this.dataAtendimento = dataAtendimento;
		this.finalizado = finalizado;
		this.total = total;
	}
	
	public FichaAtendimento(Integer id, Animal animal, Date dataAtendimento) {
		this.id = id;
		this.animal = animal;
		this.dataAtendimento = dataAtendimento;
	}

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
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

	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}

}
