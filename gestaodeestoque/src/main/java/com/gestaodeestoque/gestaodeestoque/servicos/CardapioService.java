package com.gestaodeestoque.gestaodeestoque.servicos;

import com.gestaodeestoque.gestaodeestoque.entidades.Cardapio;
import com.gestaodeestoque.gestaodeestoque.repositorios.CardapioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardapioService {
    @Autowired
    private CardapioRepository cardapioRepository;

    public List<Cardapio> listarCardapio() {
        return cardapioRepository.findAll();
    }
}
