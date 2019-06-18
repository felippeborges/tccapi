package com.tcc.felippe.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.felippe.domain.Venda;
import com.tcc.felippe.services.VendaService;

@RestController
@RequestMapping(value = "/vendas")
public class VendaResource {

	@Autowired
	private VendaService service;

	@GetMapping
	@RequestMapping(value = "/{id}")
	public ResponseEntity<Venda> find(@PathVariable Integer id) {

		Venda obj = service.buscar(id);

		return ResponseEntity.ok().body(obj);
	}
}
