package com.hudlucas.springeccomerce.services;

import com.hudlucas.springeccomerce.domain.Categoria;
import com.hudlucas.springeccomerce.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepo;

    public Categoria findById(Integer id){
        Optional<Categoria> obj = categoriaRepo.findById(id);

        if(obj.isEmpty()){
            throw new NullPointerException();
        }
        return obj.get();
    }
}
