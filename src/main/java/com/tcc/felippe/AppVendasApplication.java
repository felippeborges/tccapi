package com.tcc.felippe;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tcc.felippe.domain.Categoria;
import com.tcc.felippe.domain.Produto;
import com.tcc.felippe.repositories.CategoriaRepository;
import com.tcc.felippe.repositories.ProdutoRepository;

@SpringBootApplication
public class AppVendasApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(AppVendasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Café Tradicional ou Extraforte");
		Categoria cat2 = new Categoria(null, "Cafés Superiores");
		Categoria cat3 = new Categoria(null, "Cafés Gourmet");
		Categoria cat4 = new Categoria(null, "cafés Especiais");

		Produto p1 = new Produto(null, "Café três corações ExtraForte", 16.50);
		Produto p2 = new Produto(null, "Café Pilão ExtraForte", 15.00);
		Produto p3 = new Produto(null, "Café Prisma Qualita", 25.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2));
		cat3.getProdutos().addAll(Arrays.asList(p3));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat3));

		categoriaRepository.save(Arrays.asList(cat1, cat2, cat3, cat4));
		produtoRepository.save(Arrays.asList(p1, p2, p3));

	}

}
