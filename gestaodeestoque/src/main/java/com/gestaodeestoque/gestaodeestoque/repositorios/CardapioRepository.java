package com.gestaodeestoque.gestaodeestoque.repositorios;

import com.gestaodeestoque.gestaodeestoque.entidades.Cardapio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardapioRepository extends JpaRepository<Cardapio, Long> {
}
