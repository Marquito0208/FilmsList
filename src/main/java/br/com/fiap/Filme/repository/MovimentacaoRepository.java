package br.com.fiap.Filme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.Filme.model.Movimentacao;

public interface MovimentacaoRepository 
            extends JpaRepository<Movimentacao, Long> {
    
}
