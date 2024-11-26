package com.gestaodeestoque.gestaodeestoque.repositorios;

import com.gestaodeestoque.gestaodeestoque.entidades.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Compra, Long> {
}