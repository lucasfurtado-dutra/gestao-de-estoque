package com.gestaodeestoque.gestaodeestoque.servicos;

import com.gestaodeestoque.gestaodeestoque.entidades.Compra;
import com.gestaodeestoque.gestaodeestoque.repositorios.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CompraService {
    @Autowired
    private CompraRepository compraRepository;

    public Compra registrarCompra(Compra compra) {
        compra.setData(LocalDate.now());
        return compraRepository.save(compra);
    }

    public List<Compra> listarCompras() {
        return compraRepository.findAll();
    }
}
