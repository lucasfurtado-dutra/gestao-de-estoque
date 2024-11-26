package com.gestaodeestoque.gestaodeestoque.servicos;

import com.gestaodeestoque.gestaodeestoque.entidades.Cardapio;
import com.gestaodeestoque.gestaodeestoque.entidades.Venda;
import com.gestaodeestoque.gestaodeestoque.repositorios.CardapioRepository;
import com.gestaodeestoque.gestaodeestoque.repositorios.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VendaService {
    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private CardapioRepository cardapioRepository;

    public void salvarVenda(Venda venda) {
        Cardapio cardapio = cardapioRepository.findById(venda.getCardapio().getId()).orElse(null);

        if (cardapio != null) {
            venda.setCardapio(cardapio);

            double precoTotal = cardapio.getPreco() * venda.getQuantidadeVendida();

            venda.setPrecoTotal(precoTotal);

            vendaRepository.save(venda);
        } else {
            throw new IllegalArgumentException("Item do cardápio não encontrado!");
        }
    }

    public void atualizarVenda(Long id, Venda vendaAtualizada) {
        Venda vendaExistente = vendaRepository.findById(id).orElseThrow(() -> new RuntimeException("Venda não encontrada"));

        vendaAtualizada.setCardapio(vendaExistente.getCardapio());
        vendaExistente.setDataVenda(vendaAtualizada.getDataVenda());
        vendaExistente.setQuantidadeVendida(vendaAtualizada.getQuantidadeVendida());

        double precoTotal = vendaExistente.getCardapio().getPreco() * vendaAtualizada.getQuantidadeVendida();
        vendaExistente.setPrecoTotal(precoTotal);

        vendaRepository.save(vendaExistente);
    }

    public List<Venda> listarVendas() {
        return vendaRepository.findAll();
    }
}
