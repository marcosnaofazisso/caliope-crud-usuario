package br.com.caliope.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "T_CALI_PEDIDO")
public class Pedido {

	@ManyToOne
	@JsonIgnore
	private Usuario usuario;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Long id;

	@Column(name = "nr_pedido")
	private String numeroPedido;

	@Column(name = "nm_cliente")
	private String nomeCliente;

	@Column(name = "dt_pedido")
	private String data;

	@Column(name = "qt_items_pedido")
	private String quantidadeItems;

	@Column(name = "vl_total_pedido")
	private String valorTotal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getQuantidadeItems() {
		return quantidadeItems;
	}

	public void setQuantidadeItems(String quantidadeItems) {
		this.quantidadeItems = quantidadeItems;
	}

	public String getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal;
	}

}
