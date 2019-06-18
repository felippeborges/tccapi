package com.tcc.felippe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.tcc.felippe.domain.Categoria;
import com.tcc.felippe.repositories.CategoriaRepository;
import com.tcc.felippe.services.exception.DataIntegrityException;
import com.tcc.felippe.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository caterpository;

	public Categoria find(Integer id) {
		Categoria obj = caterpository.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! ID:" + id + ", Tipo :" + Categoria.class.getName());
		}
		return obj;
	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return caterpository.save(obj);
	}

	public Categoria update(Categoria obj) {
		find(obj.getId());
		return caterpository.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
		caterpository.delete(id);
		}catch (DataIntegrityViolationException e){
			throw new DataIntegrityException("Não foi possivel excluir esta categoria, pois ela possui produtos associados a ela.");
		}
	}
}
