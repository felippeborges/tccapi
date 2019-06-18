
package com.tcc.felippe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.felippe.domain.Venda;
import com.tcc.felippe.repositories.VendaRepository;
import com.tcc.felippe.services.exception.ObjectNotFoundException;

@Service
public class VendaService {

	@Autowired
	private VendaRepository vendaRepository;

	public Venda buscar(Integer id) {
		Venda obj = vendaRepository.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! ID:" + id + ", Tipo :" + Venda.class.getName());
		}
		return obj;
	}
}

