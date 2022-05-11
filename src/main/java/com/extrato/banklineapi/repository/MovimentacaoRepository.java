package com.extrato.banklineapi.repository;

import com.extrato.banklineapi.model.Movimentacao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {
    
}
