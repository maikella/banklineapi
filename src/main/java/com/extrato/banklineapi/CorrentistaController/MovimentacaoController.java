package com.extrato.banklineapi.CorrentistaController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.extrato.banklineapi.dto.NovaMovimentacao;
import com.extrato.banklineapi.dto.NovoCorrentista;
import com.extrato.banklineapi.model.Correntista;
import com.extrato.banklineapi.model.Movimentacao;
import com.extrato.banklineapi.repository.CorrentistaRepository;
import com.extrato.banklineapi.repository.MovimentacaoRepository;
import com.extrato.banklineapi.service.CorrentistaService;
import com.extrato.banklineapi.service.MovimentacaoService;


@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoRepository repository;

    @Autowired
    private MovimentacaoService service;

    @GetMapping
    public List<Movimentacao> findAll(){
        return repository.findAll();
    }

    @PostMapping
    public void save(@RequestBody NovaMovimentacao movimentacao){
        service.save(movimentacao);
    }
    
}
