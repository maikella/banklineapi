package com.extrato.banklineapi.service;

import com.extrato.banklineapi.dto.NovoCorrentista;
import com.extrato.banklineapi.model.Conta;
import com.extrato.banklineapi.model.Correntista;
import com.extrato.banklineapi.repository.CorrentistaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class CorrentistaService {

    @Autowired

    private CorrentistaRepository repository;

    public void save(NovoCorrentista novoCorrentista){

        Correntista correntista = new Correntista();
        correntista.setCpf(novoCorrentista.getCpf());
        correntista.setNome(novoCorrentista.getNome());


        Conta conta = new Conta();
        conta.setSaldo(0.0);
        conta.setNumero(new Date().getTime());

        correntista.setConta(conta);
        repository.save(correntista);
    }
    
}
