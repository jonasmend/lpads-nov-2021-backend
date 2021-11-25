package br.edu.fema.spring.procedimento.DTO;

import java.math.BigDecimal;

import br.edu.fema.spring.procedimento.Model.Procedimento;

public class ProcedimentoDTO {
	
	private Integer id;
	private BigDecimal valor;
	private String descricao;
	private Integer estoque;
	
	public ProcedimentoDTO(Procedimento procedimento) {
		this.id = procedimento.getId();
		this.valor = procedimento.getValor();
		this.descricao = procedimento.getDescricao();
		this.estoque = procedimento.getEstoque();
	}

	public Integer getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public Integer getEstoque() {
		return estoque;
	}
	

}
