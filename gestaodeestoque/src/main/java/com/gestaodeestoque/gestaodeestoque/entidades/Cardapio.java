package com.gestaodeestoque.gestaodeestoque.entidades;

import jakarta.persistence.*;

@Entity
public class Cardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private double preco;

    public Long getId() {
        return id;
    }

    public String getNome(){
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}

