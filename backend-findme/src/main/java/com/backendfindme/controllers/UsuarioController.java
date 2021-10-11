package com.backendfindme.controllers;

import com.backendfindme.controllers.dto.UsuarioDTO;
import com.backendfindme.controllers.dto.UsuarioFORM;
import com.backendfindme.controllers.dto.UsuarioServicosDTO;
import com.backendfindme.models.Usuario;
import com.backendfindme.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDTO> listar(){
        return usuarioService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> listarPorId(@PathVariable Long id){
        Usuario usuario = usuarioService.listarPorId(id);
        return ResponseEntity.ok().body(usuario);
    }

    /*


        @GetMapping("/meusservicos/{id}")
    public ResponseEntity<Usuario> listarMeusServicos(@RequestBody UsuarioServicosDTO usuarioFORM, @PathVariable Long id){
        Usuario usuario = usuarioService.listarMeusServicos(id);
        return ResponseEntity.ok().body(usuario);
    }

     */


    @PostMapping
    public ResponseEntity<UsuarioDTO> cadastrar(@RequestBody UsuarioFORM usuarioFORM){
        Usuario usuario = usuarioService.cadastrar(usuarioFORM);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new UsuarioDTO(usuario));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario usuario){
        usuario = usuarioService.atualizar(id, usuario);
        return ResponseEntity.ok().body(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
