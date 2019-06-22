package com.tcc.felippe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tcc.felippe.domain.Categoria;
import com.tcc.felippe.dto.CategoriaDTO;
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
		Categoria newObj = find(obj.getId());
		updateDate(newObj, obj);
		return caterpository.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			caterpository.delete(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException(
					"Não foi possivel excluir esta categoria, pois ela possui produtos associados a ela.");
		}
	}

	public List<Categoria> findAll() {
		return caterpository.findAll();
	}

	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return caterpository.findAll(pageRequest);
	}

	public Categoria fromDTO(CategoriaDTO objDTO) {
		return new Categoria(objDTO.getId(), objDTO.getNome());
	}

	private void updateDate(Categoria newObj, Categoria obj) {
		newObj.setNome(obj.getNome());

	}
}
