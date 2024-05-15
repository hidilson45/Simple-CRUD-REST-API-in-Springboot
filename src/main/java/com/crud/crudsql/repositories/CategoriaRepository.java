package com.crud.crudsql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.crudsql.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
}
