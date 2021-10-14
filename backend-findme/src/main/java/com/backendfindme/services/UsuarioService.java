package com.backendfindme.services;

import com.backendfindme.controllers.dto.UsuarioDTO;
import com.backendfindme.controllers.dto.UsuarioFORM;
import com.backendfindme.models.Usuario;
import com.backendfindme.repositories.UsuarioRepository;
import com.backendfindme.services.exceptions.ControllerNotFoundException;
import com.backendfindme.services.exceptions.DatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    // Listar todos os usuarios:
    public List<UsuarioDTO> listar(){
        List<Usuario> usuarioList = usuarioRepository.findAll();
        return UsuarioDTO.converter(usuarioList);
    }

    // Listar Usuario por id:
    public Usuario listarPorId(Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElseThrow(() -> new ControllerNotFoundException(id));
    }

    // Cadastrar Usuario:
    public Usuario cadastrar(@RequestBody UsuarioFORM usuarioFORM){
        Usuario usuario = usuarioFORM.converter(usuarioRepository);
        return usuarioRepository.save(usuario);
    }

    // Atualizaçao do Usuario:
    public Usuario atualizar(Long id, Usuario usuario){
        try {
            Usuario usuarioAtualizado = usuarioRepository.getOne(id);
            updateData(usuarioAtualizado, usuario);
            return usuarioRepository.save(usuarioAtualizado);
        } catch (EntityNotFoundException e){
            throw new ControllerNotFoundException(id);
        }
    }

    // Funcao utilizada na atualizacao:
    private void updateData(Usuario usuarioAtualizado, Usuario usuario) {
        usuarioAtualizado.setNome(usuario.getNome());
        usuarioAtualizado.setSenha(usuario.getSenha());
        usuarioAtualizado.setTelefone(usuario.getTelefone());
        usuarioAtualizado.setCep(usuario.getCep());
        usuarioAtualizado.setEndereco(usuario.getEndereco());
        usuarioAtualizado.setNumero(usuario.getNumero());
        usuarioAtualizado.setCidade(usuario.getCidade());
        usuarioAtualizado.setSigla_estado(usuario.getSigla_estado());
    }

/*
    // Deletar Usuario:
    public void delete(Long id){
        try{
            usuarioRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ControllerNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

 */

    // Deletar Usuario:
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            usuarioRepository.alteraSituacao(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ControllerNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

}
