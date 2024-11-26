package com.gestaodeestoque.gestaodeestoque.controllers;

import com.gestaodeestoque.gestaodeestoque.entidades.Cardapio;
import com.gestaodeestoque.gestaodeestoque.repositorios.CardapioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cardapio")
public class CardapioController {

    private final CardapioRepository cardapioRepository;

    @Autowired
    public CardapioController(CardapioRepository cardapioRepository) {
        this.cardapioRepository = cardapioRepository;
    }

    @GetMapping
    public String listarCardapio(Model model) {
        List<Cardapio> cardapioList = cardapioRepository.findAll();
        model.addAttribute("cardapioList", cardapioList);
        return "/cardapio/cardapio";
    }

    @GetMapping("/novo")
    public String exibeNovoItemCardapioForm(Model model) {
        model.addAttribute("cardapio", new Cardapio());
        return "/cardapio/novo-item-cardapio";
    }

    @PostMapping("/salvar")
    public String salvarItemCardapio(@ModelAttribute Cardapio cardapio) {
        cardapioRepository.save(cardapio);
        return "redirect:/cardapio";
    }

    @GetMapping("/editar/{id}")
    public String exibeEditarCardapioForm(@PathVariable Long id, Model model) {
        Cardapio cardapio = cardapioRepository.findById(id).orElseThrow(() -> new RuntimeException("Item do cardapio não encontrado!"));
        model.addAttribute("cardapio", cardapio);
        return "/cardapio/editar-item-cardapio";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizarItemCardapio(@PathVariable Long id, @ModelAttribute Cardapio cardapio) {
        cardapio.setId(id);
        cardapioRepository.save(cardapio);
        return "redirect:/cardapio";
    }

    @GetMapping("/excluir/{id}")
    public String excluirItemCardapio(@PathVariable Long id) {
        cardapioRepository.deleteById(id);
        return "redirect:/cardapio";
    }
}
