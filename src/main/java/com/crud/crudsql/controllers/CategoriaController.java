package com.crud.crudsql.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.crud.crudsql.entities.Categoria;
import com.crud.crudsql.repositories.CategoriaRepository;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;
    
    @GetMapping
    public List<Categoria> findAllCategories(){
        List<Categoria> result = repository.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public Categoria getCategoriaById(@PathVariable Long id){
        Categoria result = repository.findById(id).get();
        return result;
    }

    @PostMapping
    public Categoria insert(@RequestBody Categoria categoria){
        Categoria result = repository.save(categoria);
        return result;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@PathVariable Long id, @RequestBody Categoria categoria) {
        Categoria existingCategoria = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrado com o ID: " + id));

        existingCategoria.setNome(categoria.getNome());
        existingCategoria.setDescricao(categoria.getDescricao());

        Categoria updatedCategoria = repository.save(existingCategoria);

        return ResponseEntity.ok(updatedCategoria);
}
    
}
