package com.hudlucas.springeccomerce.configuration;

import com.hudlucas.springeccomerce.domain.Categoria;
import com.hudlucas.springeccomerce.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instaciation implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepo;

    @Override
    public void run(String... args) throws Exception {
        Categoria cat1 = new Categoria("Informática");
        Categoria cat2 = new Categoria("Escritório");

        categoriaRepo.saveAll(Arrays.asList(cat1, cat2));
    }
}
