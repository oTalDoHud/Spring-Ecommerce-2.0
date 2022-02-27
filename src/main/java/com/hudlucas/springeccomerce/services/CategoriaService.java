package com.hudlucas.springeccomerce.services;

import com.hudlucas.springeccomerce.domain.Categoria;
import com.hudlucas.springeccomerce.repositories.CategoriaRepository;
import com.hudlucas.springeccomerce.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepo;



    public Categoria findById(Integer id){
        Optional<Categoria> obj = categoriaRepo.findById(id);

         return obj.orElseThrow(() -> new ObjectNotFoundException(
                 "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }
}
