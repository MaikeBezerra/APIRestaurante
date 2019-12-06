package com.quixada.reuso.restaurante.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name = "pedidos_pratos",
	        joinColumns = {@JoinColumn(name = "pedido_id")},
			inverseJoinColumns = {@JoinColumn(name = "prato_id")})
	private List<Prato> pratos;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco entrega;
	
	private String horario;
	
	private Pagamento pagamento;
	
	private double valorTotal;
	
	public Pedido() {
		this.pratos = new ArrayList<>();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Prato> getPratos() {
		return pratos;
	}
	
	public void setPratos(List<Prato> pratos) {
		this.pratos = pratos;
	}
	
	public Endereco getEntrega() {
		return entrega;
	}
	
	public void setEntrega(Endereco entrega) {
		this.entrega = entrega;
	}
	
	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	public Pagamento getPagamento() {
		return pagamento;
	}
	
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
}
