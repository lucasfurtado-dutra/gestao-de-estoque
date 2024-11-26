package com.gestaodeestoque.gestaodeestoque.controllers;

import com.gestaodeestoque.gestaodeestoque.repositorios.CompraRepository;
import com.gestaodeestoque.gestaodeestoque.repositorios.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;

@Controller
public class InicialController {
    @GetMapping("/")
    public String exibirPaginaInicial() {
        return "index";
    }
}
