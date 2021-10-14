package com.backendfindme.controllers;

import com.backendfindme.controllers.dto.ServicoDTO;
import com.backendfindme.controllers.dto.ServicoFORM;
import com.backendfindme.models.Servico;
import com.backendfindme.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/servico")
public class ServicoController {

    @Autowired
    ServicoService servicoService;

    @GetMapping
    public List<ServicoDTO> listar(String nomeCategoria){
        return servicoService.listarPorCategoria(nomeCategoria);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servico> listarPorId(@PathVariable Long id){
        Servico servico = servicoService.listarPorId(id);
        return ResponseEntity.ok().body(servico);
    }

    @PostMapping
    public ResponseEntity<ServicoDTO> cadastrar(@RequestBody ServicoFORM servicoFORM){
        Servico servico = servicoService.cadastrar(servicoFORM);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(servico.getId()).toUri();
        return ResponseEntity.created(uri).body(new ServicoDTO(servico));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Servico> atualizar(@PathVariable Long id, @RequestBody Servico servico){
        servico = servicoService.atualizar(id, servico);
        return ResponseEntity.ok().body(servico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        servicoService.delete(id);
        return ResponseEntity.noContent().build();
    }
/*

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        servicoService.delete(id);
        return ResponseEntity.noContent().build();
    }

 */

}
