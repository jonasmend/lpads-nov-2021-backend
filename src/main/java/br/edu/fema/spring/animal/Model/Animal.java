package br.edu.fema.spring.animal.Model;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.edu.fema.spring.cliente.Model.Cliente;
import br.edu.fema.spring.especie.Model.Especie;

@Entity
public class Animal {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@ManyToOne 
	private Especie especie;
	
	@NotNull
	@ManyToOne
	private Cliente cliente;
	
	@NotNull
	@Column(nullable = false)
	private String nome;
	
	@NotNull
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date nascimento;
	
	public Animal() {}
	
	public Animal(Integer id, Especie especie, Cliente cliente, String nome, Date nascimento) {
		this.id = id;
		this.especie = especie;
		this.cliente = cliente;
		this.nome = nome;
		this.nascimento = nascimento;
	}
	
	/*public void dataFormat(String args[]) {

		  String s;
		  Format formatter = new SimpleDateFormat("dd/MM/yyyy");
		  
		  // formatter = new SimpleDateFormat("dd/MM/yyyy");
		  s = formatter.format(this.nascimento);
		  this.nascimento = formatter.;
	}*/

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Especie getEspecie() {
		return especie;
	}
	public void setEspecie(Especie especie) {
		this.especie = especie;
	}

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	

}
