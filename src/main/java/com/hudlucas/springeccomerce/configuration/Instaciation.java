package com.hudlucas.springeccomerce.configuration;

import com.hudlucas.springeccomerce.domain.Categoria;
import com.hudlucas.springeccomerce.domain.Cidade;
import com.hudlucas.springeccomerce.domain.Estado;
import com.hudlucas.springeccomerce.domain.Produto;
import com.hudlucas.springeccomerce.repositories.CategoriaRepository;
import com.hudlucas.springeccomerce.repositories.CidadeRepository;
import com.hudlucas.springeccomerce.repositories.EstadoRepository;
import com.hudlucas.springeccomerce.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

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

    @Override
    public void run(String... args) throws Exception {
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

        categoriaRepo.saveAll(Arrays.asList(cat1, cat2));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

        estadoRepository.saveAll(Arrays.asList(est1, est2));
        cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
    }
}
