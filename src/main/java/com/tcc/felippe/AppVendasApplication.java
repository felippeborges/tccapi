package com.tcc.felippe;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tcc.felippe.domain.Categoria;
import com.tcc.felippe.domain.Cidade;
import com.tcc.felippe.domain.Estado;
import com.tcc.felippe.domain.Produto;
import com.tcc.felippe.repositories.CategoriaRepository;
import com.tcc.felippe.repositories.CidadeRepository;
import com.tcc.felippe.repositories.EstadoRepository;
import com.tcc.felippe.repositories.ProdutoRepository;

@SpringBootApplication
public class AppVendasApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(AppVendasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Categoria 1");
		Categoria cat2 = new Categoria(null, "Categoria 2");
		Categoria cat3 = new Categoria(null, "Categoria 3");
		Categoria cat4 = new Categoria(null, "Categoria 4");

		Produto p1 = new Produto(null, "Produto 1", 16.50);
		Produto p2 = new Produto(null, "Produto 2", 15.00);
		Produto p3 = new Produto(null, "Produto 3", 25.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2));
		cat3.getProdutos().addAll(Arrays.asList(p3));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat3));

		categoriaRepository.save(Arrays.asList(cat1, cat2, cat3, cat4));
		produtoRepository.save(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado(null, "Goiás");
		Estado est2 = new Estado(null, "Mato Grosso");

		Cidade cid1 = new Cidade(null, "Iporá", est1);
		Cidade cid2 = new Cidade(null, "Cuiabá", est2);

		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2));
		
		estadoRepository.save(Arrays.asList(est1, est2));
		cidadeRepository.save(Arrays.asList(cid1, cid2));
		

	}

}
