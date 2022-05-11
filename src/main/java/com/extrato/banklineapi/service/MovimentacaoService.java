package com.extrato.banklineapi.service;

import java.time.LocalDateTime;

import com.extrato.banklineapi.dto.NovaMovimentacao;
import com.extrato.banklineapi.model.Correntista;
import com.extrato.banklineapi.model.Movimentacao;
import com.extrato.banklineapi.model.MovimentacaoTipo;
import com.extrato.banklineapi.repository.MovimentacaoRepository;
import com.extrato.banklineapi.repository.CorrentistaRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository repository;

    @Autowired
    private CorrentistaRepository correntistaRepository;
    public void save(NovaMovimentacao novaMovimentacao){

        Movimentacao movimentacao = new Movimentacao();

        Double valor = novaMovimentacao.getTipo() == MovimentacaoTipo.RECEITAS ? novaMovimentacao.getValor() : novaMovimentacao.getValor() * -1;

        movimentacao.setDataHora(LocalDateTime.now());
        movimentacao.setDescricao(novaMovimentacao.getDescricao());
        movimentacao.setIdConta(novaMovimentacao.getIdConta());
        movimentacao.setTipo(novaMovimentacao.getTipo());
        movimentacao.setValor(valor);

        Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);

        if(correntista != null){
            correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
            correntistaRepository.save(correntista);
        }

        repository.save(movimentacao);

    }
    
}
