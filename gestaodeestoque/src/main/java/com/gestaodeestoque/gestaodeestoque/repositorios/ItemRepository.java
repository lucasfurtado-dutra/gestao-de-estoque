package com.gestaodeestoque.gestaodeestoque.repositorios;

import com.gestaodeestoque.gestaodeestoque.entidades.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}