package br.com.fiap.Filme.model;

import java.util.Random;

public record Filme(Long id, String nome, String url, String descricao) {

    public Filme(Long id, String nome, String url, String descricao){
        var key = (id != null) ? id : Math.abs( new Random().nextLong() );
        this.id = key;
        this.nome = nome;
        this.url = url; 
        this.descricao = descricao;
    }
    
} 