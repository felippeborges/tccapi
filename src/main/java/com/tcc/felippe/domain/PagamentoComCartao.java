package com.tcc.felippe.domain;

import com.tcc.felippe.domain.enums.EstadoPagamento;

public class PagamentoComCartao extends Pagamento{

	private Integer numeroDeParcelas;

	public PagamentoComCartao() {
	
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Venda venda,Integer numeroDeparcelas) {
		super(id, estado, venda);
		this.numeroDeParcelas = numeroDeparcelas;
	}
	
}
