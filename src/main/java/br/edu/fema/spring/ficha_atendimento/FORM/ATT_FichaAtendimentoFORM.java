package br.edu.fema.spring.ficha_atendimento.FORM;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class ATT_FichaAtendimentoFORM {
	
	private Integer id;
	
	private char finalizado = 'N';
	

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public char getFinalizado() {
		return finalizado;
	}
	public void setFinalizado(char finalizado) {
		this.finalizado = finalizado;
	}

}
