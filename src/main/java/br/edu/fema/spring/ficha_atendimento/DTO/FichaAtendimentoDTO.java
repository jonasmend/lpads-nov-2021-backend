package br.edu.fema.spring.ficha_atendimento.DTO;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Date;

import org.javamoney.moneta.Money;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.edu.fema.spring.animal.Model.Animal;
import br.edu.fema.spring.ficha_atendimento.Model.FichaAtendimento;

public class FichaAtendimentoDTO {
	
	private Integer id;
	private Animal animal;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataAtendimento;
	
	private char finalizado;
	
	private BigDecimal total;
	
	public FichaAtendimentoDTO(FichaAtendimento ficha) {
		this.id = ficha.getId();
		this.animal = ficha.getAnimal();
		this.dataAtendimento = ficha.getDataAtendimento();
		this.finalizado = ficha.getFinalizado();
		this.total = ficha.getTotal();
	}

	public Integer getId() {
		return id;
	}

	public Animal getAnimal() {
		return animal;
	}

	public Date getDataAtendimento() {
		return dataAtendimento;
	}

	public char getFinalizado() {
		return finalizado;
	}

	public BigDecimal getTotal() {
		return total;
	}
	

}
