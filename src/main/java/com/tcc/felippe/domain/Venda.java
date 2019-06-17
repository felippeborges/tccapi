package com.tcc.felippe.domain;

import java.util.Date;

public class Venda {
	private Integer id;
	private Date data;

	private Pagamento pagamento;
	private Cliente cliente;
	private Endereco enderecoDeEntrega;

	public Venda() {

	}

	public Venda(Integer id, Date data, Pagamento pagamento, Cliente cliente, Endereco enderecoDeEntrega) {
		super();
		this.id = id;
		this.data = data;
		this.pagamento = pagamento;
		this.cliente = cliente;
		this.enderecoDeEntrega = enderecoDeEntrega;
	}

}
