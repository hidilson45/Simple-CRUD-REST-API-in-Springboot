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

import com.crud.crudsql.entities.Produto;
import com.crud.crudsql.repositories.ProdutoRepository;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping
    public List<Produto> findAllProdutos() {
       List<Produto> result = repository.findAll();
       return result;
    }

    @GetMapping(value = "/{id}")
    public Produto findOneProduct(@PathVariable Long id) {
       Produto result = repository.findById(id).get();
       return result;
    }

    @PostMapping
    public Produto insert(@RequestBody Produto produto) {
       Produto result = repository.save(produto);
       return result;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto produto) {
        Produto existingProduto = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado com o ID: " + id));

        existingProduto.setNome(produto.getNome());
        existingProduto.setDescricao(produto.getDescricao());
        existingProduto.setPreco(produto.getPreco());

        Produto updatedProduto = repository.save(existingProduto);

        return ResponseEntity.ok(updatedProduto);
}
    
}
