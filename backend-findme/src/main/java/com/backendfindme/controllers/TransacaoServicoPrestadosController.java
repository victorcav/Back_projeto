package com.backendfindme.controllers;

import com.backendfindme.controllers.dto.TransacaoServicoPrestadoDTO;
import com.backendfindme.services.TransacaoServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transacao_servico_prestados")
public class TransacaoServicoPrestadosController {

    @Autowired
    TransacaoServicoService transacaoServicoService;

    @GetMapping
    public List<TransacaoServicoPrestadoDTO> listarTransacaoServicoPrestadas(Long meuIdPrestador){
        return transacaoServicoService.listarTransacaoServicoPrestadas(meuIdPrestador);
    }
}
