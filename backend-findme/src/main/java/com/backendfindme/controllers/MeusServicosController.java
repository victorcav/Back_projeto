package com.backendfindme.controllers;

import com.backendfindme.controllers.dto.ServicoDTO;
import com.backendfindme.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/meus_servicos")
public class MeusServicosController {

    @Autowired
    ServicoService servicoService;

    @GetMapping
    public List<ServicoDTO> listarMeusServicos(Long meuId){
        return servicoService.listarMeusServicos(meuId);
    }
}
