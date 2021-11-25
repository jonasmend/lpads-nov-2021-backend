package br.edu.fema.spring.procedimento_realizado.FORM;

import br.edu.fema.spring.procedimento.Model.Procedimento;

public class ATT_ProcedimentoRealizadoFORM {
	
	private Integer id;
	
	private Procedimento procedimento;
	
	private Integer quantidade;
	
	// private float total;
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Procedimento getProcedimento() {
		return procedimento;
	}
	public void setProcedimento(Procedimento procedimento) {
		this.procedimento = procedimento;
	}

	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
/*
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
*/

}
