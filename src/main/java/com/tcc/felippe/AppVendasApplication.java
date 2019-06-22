package com.tcc.felippe;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tcc.felippe.domain.Categoria;
import com.tcc.felippe.domain.Cidade;
import com.tcc.felippe.domain.Cliente;
import com.tcc.felippe.domain.Endereco;
import com.tcc.felippe.domain.Estado;
import com.tcc.felippe.domain.ItemVenda;
import com.tcc.felippe.domain.Pagamento;
import com.tcc.felippe.domain.PagamentoComCartao;
import com.tcc.felippe.domain.Produto;
import com.tcc.felippe.domain.Venda;
import com.tcc.felippe.domain.enums.EstadoPagamento;
import com.tcc.felippe.domain.enums.TipoCliente;
import com.tcc.felippe.repositories.CategoriaRepository;
import com.tcc.felippe.repositories.CidadeRepository;
import com.tcc.felippe.repositories.ClienteRepository;
import com.tcc.felippe.repositories.EnderecoRepository;
import com.tcc.felippe.repositories.EstadoRepository;
import com.tcc.felippe.repositories.ItemVendaRepository;
import com.tcc.felippe.repositories.PagamentoRepository;
import com.tcc.felippe.repositories.ProdutoRepository;
import com.tcc.felippe.repositories.VendaRepository;

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
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private VendaRepository vendaRepository;
	@Autowired
	private PagamentoRepository pagamenRepository;
	@Autowired
	private ItemVendaRepository itemVendaRepository;

	public static void main(String[] args) {
		SpringApplication.run(AppVendasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//_____________________CATEGORIA__PRODUTO_________________________________________//
		Categoria cat1 = new Categoria(null, "Categoria 1");
		Categoria cat2 = new Categoria(null, "Categoria 2");
		Categoria cat3 = new Categoria(null, "Categoria 3");
		Categoria cat4 = new Categoria(null, "Categoria 4");

		Produto p1 = new Produto(null, "Produto 1", 16.50);
		Produto p2 = new Produto(null, "Produto 2", 15.00);
		Produto p3 = new Produto(null, "Produto 3", 25.00);
		Produto p4 = new Produto(null, "computador 4", 1.50);
		Produto p5 = new Produto(null, "Produto 5", 5.00);
		Produto p6 = new Produto(null, "Produto 6", 125.00);
		Produto p7 = new Produto(null, "Produto 7", 126.50);
		Produto p8 = new Produto(null, "Produto 8", 145.00);
		Produto p9 = new Produto(null, "Produto 9", 250.00);
		Produto p10 = new Produto(null, "Produto 10", 160.50);
		Produto p11 = new Produto(null, "Produto 11", 150.00);
		Produto p12 = new Produto(null, "Produto 12", 258.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p5, p9, p4, p3, p2));
		cat2.getProdutos().addAll(Arrays.asList(p2, p6, p10));
		cat3.getProdutos().addAll(Arrays.asList(p3, p7, p11));
		cat4.getProdutos().addAll(Arrays.asList(p4, p8, p12));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1, cat3));
		p4.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p5.getCategorias().addAll(Arrays.asList(cat1));
		p6.getCategorias().addAll(Arrays.asList(cat2));
		p7.getCategorias().addAll(Arrays.asList(cat3));
		p8.getCategorias().addAll(Arrays.asList(cat4));
		p9.getCategorias().addAll(Arrays.asList(cat1));
		p10.getCategorias().addAll(Arrays.asList(cat2));
		p11.getCategorias().addAll(Arrays.asList(cat3));
		p12.getCategorias().addAll(Arrays.asList(cat4));

		categoriaRepository.save(Arrays.asList(cat1, cat2, cat3, cat4));
		produtoRepository.save(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12));
//____________________________CIDADE_ESTADO________________________________________________//

		Estado est1 = new Estado(null, "Goiás");
		Estado est2 = new Estado(null, "Mato Grosso");

		Cidade cid1 = new Cidade(null, "Iporá", est1);
		Cidade cid2 = new Cidade(null, "Cuiabá", est2);

		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2));

		estadoRepository.save(Arrays.asList(est1, est2));
		cidadeRepository.save(Arrays.asList(cid1, cid2));

//__________________________CLIENTE_ENDEREÇO_________________________________________________//		

		Cliente cli1 = new Cliente(null, "Felippe Borges", "Felippe-b@hotmail.com", "025905781-99",
				TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("6499271-1866", "36743599"));

		Endereco e1 = new Endereco(null, "Av. R1 ESQ. Rua D", "S/N", "Proximo ao Hospital Municipal", "Mato Grosso",
				"76200-000", cli1, cid1);
		Endereco e2 = new Endereco(null, "Teste Endereço logradouro", "100", "Apto 102", "Central", "76200-000", cli1,
				cid2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteRepository.save(Arrays.asList(cli1));
		enderecoRepository.save(Arrays.asList(e1, e2));

//______________________________VENDA_________________________________________________________________________________//

		SimpleDateFormat data = new SimpleDateFormat("dd/mm/yyyy HH:mm");

		Venda venda1 = new Venda(null, data.parse("17/06/2019 03:15"), cli1, e1);
		Venda venda2 = new Venda(null, data.parse("17/06/2019 03:21"), cli1, e2);

		Pagamento pg1 = new PagamentoComCartao(null, EstadoPagamento.PAGO, venda1, 10);
		venda1.setPagamento(pg1);

		Pagamento pg2 = new PagamentoComCartao(null, EstadoPagamento.AGUARDANDO_PAGAMENTO, venda2, 12);
		venda2.setPagamento(pg2);

		cli1.getVendas().addAll(Arrays.asList(venda1, venda2));

		vendaRepository.save(Arrays.asList(venda1, venda2));
		pagamenRepository.save(Arrays.asList(pg1, pg2));

//______________________________________ITENS_DA_VENDA___________________________________________________________________//

		ItemVenda itns1 = new ItemVenda(venda1, p1, 0.00, 1, 100.00);

		ItemVenda itns2 = new ItemVenda(venda1, p2, 0.00, 2, 500.00);

		venda1.getItens().addAll(Arrays.asList(itns1, itns2));

		p1.getItens().addAll(Arrays.asList(itns1));
		p2.getItens().addAll(Arrays.asList(itns1));

		itemVendaRepository.save(Arrays.asList(itns1, itns2));
	}

}
