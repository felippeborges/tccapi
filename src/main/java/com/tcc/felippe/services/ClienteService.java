package com.tcc.felippe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.felippe.domain.Cliente;
import com.tcc.felippe.repositories.ClienteRepository;
import com.tcc.felippe.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente buscar(Integer id) {
		Cliente obj = clienteRepository.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! ID:" + id + ", Tipo :" + Cliente.class.getName());
		}
		return obj;
	}
}
