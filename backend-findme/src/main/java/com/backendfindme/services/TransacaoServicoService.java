package com.backendfindme.services;


import com.backendfindme.controllers.dto.TransacaoServicoContratadoDTO;

import com.backendfindme.controllers.dto.TransacaoServicoPrestadoDTO;
import com.backendfindme.models.TransacaoServico;
import com.backendfindme.repositories.TransacaoServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoServicoService {

    @Autowired
    TransacaoServicoRepository transacaoServicoRepository;

    // Listar todos as Minhas Transacoes Servicos Contratados:
    public List<TransacaoServicoContratadoDTO> listarTransacaoServicoContratadas(Long meuIdContratante){
        List<TransacaoServico> transacaoServicoList = transacaoServicoRepository.listarTransacaoServicoContratadas(meuIdContratante);
        return TransacaoServicoContratadoDTO.converter(transacaoServicoList);
    }

    // Listar todos as Minhas Transacoes Servicos Prestados:
    public List<TransacaoServicoPrestadoDTO> listarTransacaoServicoPrestadas(Long meuIdPrestador){
        List<TransacaoServico> transacaoServicoList = transacaoServicoRepository.listarTransacaoServicoPrestadas(meuIdPrestador);
        return TransacaoServicoPrestadoDTO.converter(transacaoServicoList);
    }
}
