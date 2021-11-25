package br.edu.fema.spring.procedimento_realizado.FORM;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import br.edu.fema.spring.ficha_atendimento.Model.FichaAtendimento;
import br.edu.fema.spring.procedimento.Model.Procedimento;

public class ProcedimentoRealizadoFORM {
	
	private Integer id;
	
	@NotNull
	private FichaAtendimento fichaAtendimento;
	
	private Procedimento procedimento;
	
	private Integer quantidade;
	
	private BigDecimal total;

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public FichaAtendimento getFichaAtendimento() {
		return fichaAtendimento;
	}
	public void setFichaAtendimento(FichaAtendimento fichaAtendimento) {
		this.fichaAtendimento = fichaAtendimento;
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

	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}

}
