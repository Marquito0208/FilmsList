package br.com.fiap.Filme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.Filme.model.Filme;


public interface FilmeListRepository extends JpaRepository <Filme, Long> {

    
}