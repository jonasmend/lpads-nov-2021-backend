package br.edu.fema.spring.procedimento_realizado.Model;



import java.math.BigDecimal;
import java.sql.Date;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.edu.fema.spring.ficha_atendimento.Model.FichaAtendimento;
import br.edu.fema.spring.procedimento.Model.Procedimento;

@Entity
public class ProcedimentoRealizado {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne 
	@JoinColumn(name = "ficha_atendimento")
	@NotNull
	private FichaAtendimento fichaAtendimento;
	
	@ManyToOne
	@JoinColumn(name = "procedimento")
	@JsonManagedReference
	private Procedimento procedimento;
	
	private Integer quantidade;
	
	private BigDecimal total;
	
	public ProcedimentoRealizado() {}
	
	/*
	public ProcedimentoRealizado(Integer id, FichaAtendimento fichaAtendimento, Procedimento procedimento) {
		this.id = id;
		this.fichaAtendimento = fichaAtendimento;
		this.procedimento = procedimento;
	}
	*/
	
	public ProcedimentoRealizado(Integer id, FichaAtendimento fichaAtendimento, Procedimento procedimento, Integer quantidade, BigDecimal total) {
		this.id = id;
		this.fichaAtendimento = fichaAtendimento;
		this.procedimento = procedimento;
		this.quantidade = quantidade;
		this.total = total;
	}

	
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
