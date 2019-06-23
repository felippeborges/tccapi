
package com.tcc.felippe.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.felippe.domain.ItemVenda;
import com.tcc.felippe.domain.Venda;
import com.tcc.felippe.domain.enums.EstadoPagamento;
import com.tcc.felippe.repositories.ItemVendaRepository;
import com.tcc.felippe.repositories.PagamentoRepository;
import com.tcc.felippe.repositories.ProdutoRepository;
import com.tcc.felippe.repositories.VendaRepository;
import com.tcc.felippe.services.exception.ObjectNotFoundException;

@Service
public class VendaService {

	@Autowired
	private VendaRepository vendaRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private ItemVendaRepository itemVendaRepository;

	public Venda buscar(Integer id) {
		Venda obj = vendaRepository.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! ID:" + id + ", Tipo :" + Venda.class.getName());
		}
		return obj;
	}

	public Venda insert(Venda obj) {
		obj.setId(null);
		obj.setData(new Date());
		obj.getPagamento().setEstado(EstadoPagamento.AGUARDANDO_PAGAMENTO);
		obj.getPagamento().setVenda(obj);

		obj = vendaRepository.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		for (ItemVenda iv : obj.getItens()) {
			iv.setDesconto(0.0);
			iv.setPreco(produtoRepository.findOne(iv.getProduto().getId()).getPreco());
			iv.setVenda(obj);
		}
		itemVendaRepository.save(obj.getItens());
		return obj;
	}
}
