package com.gestaodeestoque.gestaodeestoque.controllers;

import com.gestaodeestoque.gestaodeestoque.entidades.Compra;
import com.gestaodeestoque.gestaodeestoque.entidades.Item;
import com.gestaodeestoque.gestaodeestoque.repositorios.CompraRepository;
import com.gestaodeestoque.gestaodeestoque.repositorios.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public String listarCompras(Model model) {
        List<Compra> compras = compraRepository.findAll();
        model.addAttribute("compras", compras);
        return "compras/compras";
    }

    @GetMapping("/novo")
    public String exibirFormularioCompra(Model model) {
        List<Item> itemList = itemRepository.findAll();
        model.addAttribute("compra", new Compra());
        model.addAttribute("itemList", itemList);
        return "compras/nova-compra";
    }

    @PostMapping("/salvar")
    public String salvarCompra(@ModelAttribute Compra compra) {
        compraRepository.save(compra);
        return "redirect:/compras";
    }

    @GetMapping("/excluir/{id}")
    public String excluirCompra(@PathVariable Long id) {
        compraRepository.deleteById(id);
        return "redirect:/compras";
    }

    @GetMapping("/editar/{id}")
    public String exibirEditarCompraForm(@PathVariable Long id, Model model) {
        Compra compra = compraRepository.findById(id).orElseThrow(() -> new RuntimeException("Compra não encontrada"));
        model.addAttribute("compra", compra);
        return "compras/editar-compra";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizarCompra(@PathVariable Long id, @ModelAttribute Compra compra) {
        Compra compraExistente = compraRepository.findById(id).orElseThrow(() -> new RuntimeException("Venda não encontrada"));
        compraExistente.setData(compra.getData());
        compraExistente.setPreco(compra.getPreco());
        compraRepository.save(compraExistente);
        return "redirect:/compras";
    }
}
