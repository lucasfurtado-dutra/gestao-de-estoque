package com.gestaodeestoque.gestaodeestoque.repositorios;

import com.gestaodeestoque.gestaodeestoque.entidades.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}