package br.edu.fema.spring.procedimento.FORM;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

public class ProcedimentoFORM {
	
	private Integer id;
	
	
	private BigDecimal valor;
	
	
	private String descricao;
	
	
	private Integer estoque;
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getEstoque() {
		return estoque;
	}
	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

}
