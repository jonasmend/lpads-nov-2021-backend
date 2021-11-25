package br.edu.fema.spring.especie.DTO;

import br.edu.fema.spring.especie.Model.Especie;

public class EspecieDTO {
	
	private Integer id;
	private String descricao;
	
	public EspecieDTO(Especie especie) {
		this.id = especie.getId();
		this.descricao = especie.getDescricao();
	}

	public Integer getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

}
