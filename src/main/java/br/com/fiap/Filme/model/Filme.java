package br.com.fiap.Filme.model;

import java.util.Random;

public record Filme(Long id, String nome, String foto) {

    public Filme(Long id, String nome, String foto){
        var key = (id != null) ? id : Math.abs( new Random().nextLong() );
        this.id = key;
        this.nome = nome;
        this.foto = foto; 
    }
    
} 