package com.tcc.felippe;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tcc.felippe.domain.Categoria;
import com.tcc.felippe.repositories.CategoriaRepository;

@SpringBootApplication
public class AppVendasApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(AppVendasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Café Tradicional ou Extraforte");
		Categoria cat2 = new Categoria(null, "Cafés Superiores");
		Categoria cat3 = new Categoria(null, "Cafés Gourmet");
		Categoria cat4 = new Categoria(null, "cafés Especiais");

		categoriaRepository.save(Arrays.asList(cat1, cat2, cat3, cat4));

	}

}
