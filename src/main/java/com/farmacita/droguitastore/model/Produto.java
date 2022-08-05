package com.farmacita.droguitastore.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String nomeProd;

	@NotNull
	@Positive
	private BigDecimal valor;

	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;

	@OneToMany(mappedBy = "pedido")
	@JsonIgnoreProperties("pedido")
	private List<Cliente> cliente;

//	public void tipom(int index) {
//		if (index == 0) {
//			System.out.println(this.tipo[0]);
//		} else if (index == 1) {
//			System.out.println(this.tipo[1]);
//		} else if (index == 2) {
//			System.out.println(this.tipo[2]);
//		}
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeProd() {
		return nomeProd;
	}

	public void setNomeProd(String nomeProd) {
		this.nomeProd = nomeProd;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
