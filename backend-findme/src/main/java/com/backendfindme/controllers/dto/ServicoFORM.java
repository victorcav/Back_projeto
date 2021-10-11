package com.backendfindme.controllers.dto;

import com.backendfindme.models.ListaCategoria;
import com.backendfindme.models.Servico;
import com.backendfindme.models.Usuario;
import com.backendfindme.repositories.ServicoRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServicoFORM {

    private String titulo;
    private String descricao;
    private ListaCategoria categoria;
    private Usuario usuario;
    private double valor;

    public Servico converter(ServicoRepository servicoRepository){
        return new Servico(titulo, descricao, categoria, usuario, valor);
    }
}
