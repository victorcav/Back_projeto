package com.backendfindme.controllers;

import com.backendfindme.controllers.dto.TransacaoServicoContratadoDTO;
import com.backendfindme.services.TransacaoServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transacao_servico_contratados")
public class TransacaoServicoContratadosController {

    @Autowired
    TransacaoServicoService transacaoServicoService;

    @GetMapping
    public List<TransacaoServicoContratadoDTO> listarTransacaoServicoContratadas(Long meuIdContratante){
        return transacaoServicoService.listarTransacaoServicoContratadas(meuIdContratante);
    }

}
