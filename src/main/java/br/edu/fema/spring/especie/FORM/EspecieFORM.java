package br.edu.fema.spring.especie.FORM;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class EspecieFORM {
	
	private Integer id;
	
	@NotNull
	@Column(length=100, nullable = false)
	private String descricao;

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
