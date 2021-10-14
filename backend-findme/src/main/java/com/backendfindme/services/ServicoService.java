package com.backendfindme.services;

import com.backendfindme.controllers.dto.ServicoDTO;
import com.backendfindme.controllers.dto.ServicoFORM;
import com.backendfindme.models.Servico;
import com.backendfindme.repositories.ServicoRepository;
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
public class ServicoService {

    @Autowired
    ServicoRepository servicoRepository;

    // Filtar todos os servicos de uma categoria:
    public List<ServicoDTO> listarPorCategoria(String nomeCategoria){
        List<Servico> servicoList = servicoRepository.filtrarPorCategoria(nomeCategoria);
        return ServicoDTO.converter(servicoList);
    }

    // Listar Servico por id:
    public Servico listarPorId(Long id){
        Optional<Servico> servico = servicoRepository.findById(id);
        return servico.orElseThrow(() -> new ControllerNotFoundException(id));
    }

    // Cadastrar Servico:
    public Servico cadastrar(@RequestBody ServicoFORM servicoFORM){
        Servico servico = servicoFORM.converter(servicoRepository);
        return servicoRepository.save(servico);
    }

    // Atualizaçao do Servico:
    public Servico atualizar(Long id, Servico servico){
        try {
            Servico servicoAtualizado = servicoRepository.getOne(id);
            updateData(servicoAtualizado, servico);
            return servicoRepository.save(servico);
        } catch (EntityNotFoundException e){
            throw new ControllerNotFoundException(id);
        }
    }

    // Funcao utilizada na atualizacao:
    private void updateData(Servico servicoAtualizado, Servico servico) {
        servicoAtualizado.setTitulo(servico.getTitulo());
        servicoAtualizado.setDescricao(servico.getDescricao());
        servicoAtualizado.setValor(servico.getValor());
    }

    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            servicoRepository.alteraSituacao(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ControllerNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }
/*

    // Deletar Servico:
    public void delete(Long id){
        try{
            servicoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ControllerNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

 */


}
