package com.tcc.felippe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.felippe.domain.Categoria;
import com.tcc.felippe.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository caterpository;

	public Categoria buscar(Integer id) {
		Categoria obj = caterpository.findOne(id);
		return obj;
	}
}
