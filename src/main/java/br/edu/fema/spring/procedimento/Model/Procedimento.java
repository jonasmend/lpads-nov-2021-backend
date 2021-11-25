package br.edu.fema.spring.procedimento.Model;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.edu.fema.spring.procedimento_realizado.Model.ProcedimentoRealizado;

@Entity
public class Procedimento {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	private BigDecimal valor;
	
	@NotNull
	private String descricao;
	
	@NotNull
	private Integer estoque;
	
	@OneToMany(targetEntity=ProcedimentoRealizado.class, mappedBy = "procedimento", fetch = FetchType.LAZY)
	//@JsonManagedReference
	private Set<ProcedimentoRealizado> procedimento_realizado;
	
	public Procedimento() {}
	
	public Procedimento(Integer id, BigDecimal valor, String descricao, Integer estoque) {
		this.id = id;
		this.valor = valor;
		this.descricao = descricao;
		this.estoque = estoque;
	}

	
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
