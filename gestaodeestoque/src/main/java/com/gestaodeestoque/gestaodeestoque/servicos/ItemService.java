package com.gestaodeestoque.gestaodeestoque.servicos;

import com.gestaodeestoque.gestaodeestoque.entidades.Item;
import com.gestaodeestoque.gestaodeestoque.repositorios.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> listarItens() {
        return itemRepository.findAll();
    }

    public Item adicionarItem(Item item) {
        return itemRepository.save(item);
    }

    public Item atualizarQuantidade(Long id, int novaQuantidade) {
        Item item = itemRepository.findById(id).orElseThrow();
        item.setQuantidade(novaQuantidade);
        return itemRepository.save(item);
    }
}
