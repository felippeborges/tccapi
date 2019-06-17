package com.tcc.felippe.domain.enums;

public enum EstadoPagamento {

	AGUARDANDO_PAGAMENTO(1, "Aguandando Pagamento"), PAGO(2, "Pago"), CANCELADO(3, "Cancelado");

	private int cod;
	private String descricao;

	private EstadoPagamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static EstadoPagamento toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (EstadoPagamento x : EstadoPagamento.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("ID inválido:" + cod);
	}
}
