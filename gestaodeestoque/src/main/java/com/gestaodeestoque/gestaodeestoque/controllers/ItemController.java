package com.gestaodeestoque.gestaodeestoque.controllers;

import com.gestaodeestoque.gestaodeestoque.entidades.Item;
import com.gestaodeestoque.gestaodeestoque.repositorios.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/itens")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;
    @GetMapping
    public String listarItens(Model model) {
        List<Item> itens = itemRepository.findAll();
        model.addAttribute("itens", itens);
        return "itensestoque/itens";
    }

    @GetMapping("/novo")
    public String exibirFormularioNovoItem(Model model) {
        model.addAttribute("item", new Item());
        return "itensestoque/novo-item";
    }

    @PostMapping("/salvar")
    public String salvarItem(@ModelAttribute Item item) {
        itemRepository.save(item);
        return "redirect:/itens";
    }

    @GetMapping("/excluir/{id}")
    public String excluirItem(@PathVariable Long id) {
        itemRepository.deleteById(id);
        return "redirect:/itens";
    }

    @GetMapping("/editar/{id}")
    public String exibirFormularioEdicao(@PathVariable Long id, Model model) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("item", item);
        return "itensestoque/editar-item";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizarItem(@PathVariable Long id, @ModelAttribute Item item) {
        item.setId(id);
        itemRepository.save(item);
        return "redirect:/itens";
    }


}
