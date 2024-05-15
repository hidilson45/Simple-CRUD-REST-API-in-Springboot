package com.crud.crudsql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.crudsql.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    
} 
