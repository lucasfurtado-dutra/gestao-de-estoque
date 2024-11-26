package com.gestaodeestoque.gestaodeestoque.controllers;

import com.gestaodeestoque.gestaodeestoque.entidades.Cardapio;
import com.gestaodeestoque.gestaodeestoque.entidades.Venda;
import com.gestaodeestoque.gestaodeestoque.repositorios.VendaRepository;
import com.gestaodeestoque.gestaodeestoque.repositorios.CardapioRepository;
import com.gestaodeestoque.gestaodeestoque.servicos.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    private final VendaRepository vendaRepository;
    private final CardapioRepository cardapioRepository;

    @Autowired
    public VendaController(VendaRepository vendaRepository, CardapioRepository cardapioRepository) {
        this.vendaRepository = vendaRepository;
        this.cardapioRepository = cardapioRepository;
    }

    @GetMapping
    public String listarVendas(Model model) {
        model.addAttribute("vendas", vendaRepository.findAll());
        return "vendas/vendas";
    }

    @GetMapping("/novo")
    public String exibirFormularioNovaVenda(Model model) {
        List<Cardapio> cardapioList = cardapioRepository.findAll();
        model.addAttribute("venda", new Venda());
        model.addAttribute("cardapioList", cardapioList);
        return "vendas/nova-venda";
    }

    @PostMapping("/salvar")
    public String salvarVenda(@ModelAttribute Venda venda) {
        vendaService.salvarVenda(venda);
        return "redirect:/vendas";
    }

    @GetMapping("/excluir/{id}")
    public String excluirVenda(@PathVariable Long id) {
        vendaRepository.deleteById(id);
        return "redirect:/vendas";
    }

    @GetMapping("/editar/{id}")
    public String exibirEditarVendaForm(@PathVariable Long id, Model model) {
        Venda venda = vendaRepository.findById(id).orElseThrow(() -> new RuntimeException("Venda não encontrada"));
        model.addAttribute("venda", venda);
        return "vendas/editar-venda";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizarVenda(@PathVariable Long id, @ModelAttribute Venda venda) {
        vendaService.atualizarVenda(id, venda);
        return "redirect:/vendas";
    }
}
