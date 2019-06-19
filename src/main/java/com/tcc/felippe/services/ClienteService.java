package com.tcc.felippe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tcc.felippe.domain.Cliente;
import com.tcc.felippe.dto.ClienteDTO;
import com.tcc.felippe.repositories.ClienteRepository;
import com.tcc.felippe.services.exception.DataIntegrityException;
import com.tcc.felippe.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clientepository;

	public Cliente find(Integer id) {
		Cliente obj = clientepository.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! ID:" + id + ", Tipo :" + Cliente.class.getName());
		}
		return obj;
	}

	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateDate(newObj, obj);
		return clientepository.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			clientepository.delete(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException(
					"Não foi possivel excluir este Cliente, pois ele possui vinculo com venda.");
		}
	}

	public List<Cliente> findAll() {
		return clientepository.findAll();
	}

	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return clientepository.findAll(pageRequest);
	}

	public Cliente fromDTO(ClienteDTO objDTO) {
		return new Cliente(objDTO.getId(), objDTO.getNome(), objDTO.getEmail(), null, null);
	}
	private void updateDate(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}
}
