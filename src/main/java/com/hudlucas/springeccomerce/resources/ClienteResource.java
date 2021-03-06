package com.hudlucas.springeccomerce.resources;

import com.hudlucas.springeccomerce.domain.Categoria;
import com.hudlucas.springeccomerce.domain.Cliente;
import com.hudlucas.springeccomerce.services.CategoriaService;
import com.hudlucas.springeccomerce.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

    @Autowired
    ClienteService service;

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Integer id){
        Cliente obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
