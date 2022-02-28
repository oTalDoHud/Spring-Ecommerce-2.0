package com.hudlucas.springeccomerce.configuration;

import com.hudlucas.springeccomerce.domain.*;
import com.hudlucas.springeccomerce.domain.enums.EstadoPagamento;
import com.hudlucas.springeccomerce.domain.enums.TipoCliente;
import com.hudlucas.springeccomerce.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@Configuration
public class Instaciation implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepo;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        Categoria cat1 = new Categoria("Informática");
        Categoria cat2 = new Categoria("Escritório");

        Produto p1 = new Produto("Computador", 2000.00);
        Produto p2 = new Produto("Impressora", 800.00);
        Produto p3 = new Produto("Mouse", 80.00);

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));

        Estado est1 = new Estado("Minas Gerais");
        Estado est2 = new Estado("São Paulo");

        Cidade cid1 = new Cidade("Uberlândia", est1);
        Cidade cid2 = new Cidade("São Paulo", est2);
        Cidade cid3 = new Cidade("Campinas", est2);

        est1.getCidades().add(cid1);
        est2.getCidades().addAll(Arrays.asList(cid2, cid3));

        Cliente cli1 = new Cliente("Maria Silva", "Maria@gmail.com", "512.512.656-77", TipoCliente.PESSOA_FISICA);
        cli1.getTelefones().addAll(Arrays.asList("11 93232-5454", "2454-4875"));

        Endereco e1 = new Endereco("Rua Flores", "330", "apto 303", "Jardim", "38220094", cli1, cid1);

        Endereco e2 = new Endereco("Rua Matos", "105", "sala 93", "Centro", "08440440", cli1, cid2);

        cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

        Pedido ped1 = new Pedido(sdf.parse("30/09/2017 10:32:00"), cli1, e1);
        Pedido ped2 = new Pedido(sdf.parse("10/10/2017 19:35:00"), cli1, e2);


        Pagamento pagt1 = new PagamentoComCartao(EstadoPagamento.QUITADO, ped1, 6);
        ped1.setPagamento(pagt1);

        Pagamento pagt2 = new PagamentoComBoleto(EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
        ped2.setPagamento(pagt2);

        cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));



        categoriaRepo.saveAll(Arrays.asList(cat1, cat2));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

        estadoRepository.saveAll(Arrays.asList(est1, est2));
        cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));

        clienteRepository.saveAll(Arrays.asList(cli1));
        enderecoRepository.saveAll(Arrays.asList(e1, e2));

        pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
        pagamentoRepository.saveAll(Arrays.asList(pagt1, pagt2));

        ItemPedido ip1 =  new ItemPedido(ped1, p1, 0.0, 1, 2000.0);
        ItemPedido ip2 =  new ItemPedido(ped1, p3, 0.0, 2, 80.0);
        ItemPedido ip3 =  new ItemPedido(ped2, p2, 100.0, 1, 800.0);

        ped1.getItens().addAll(Arrays.asList(ip1, ip2));
        ped2.getItens().addAll(Arrays.asList(ip3));

        p1.getItens().addAll(Arrays.asList(ip1));
        p2.getItens().addAll(Arrays.asList(ip3));
        p3.getItens().addAll(Arrays.asList(ip2));

        itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
    }
}
