package br.edu.fema.spring.procedimento_realizado.DTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import br.edu.fema.spring.ficha_atendimento.Model.FichaAtendimento;
import br.edu.fema.spring.procedimento.Model.Procedimento;
import br.edu.fema.spring.procedimento_realizado.Model.ProcedimentoRealizado;

public class ProcedimentoRealizadoDTO {

	private Integer id;
	private FichaAtendimento fichaAtendimento;
	private Procedimento procedimento;
	private Integer quantidade;
	private BigDecimal total;
	
	public ProcedimentoRealizadoDTO(ProcedimentoRealizado procedimento) {
		this.id = procedimento.getId();
		this.fichaAtendimento = procedimento.getFichaAtendimento();
		this.procedimento = procedimento.getProcedimento();
		this.quantidade = procedimento.getQuantidade();
		this.total = procedimento.getTotal();
	}

	public Integer getId() {
		return id;
	}

	public FichaAtendimento getFichaAtendimento() {
		return fichaAtendimento;
	}

	public Procedimento getProcedimento() {
		return procedimento;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public BigDecimal getTotal() {
		return total;
	}
	
}
