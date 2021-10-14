package com.backendfindme.controllers.dto;

import com.backendfindme.models.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ServicoDTO {

    private String titulo;
    private String descricao;
    private Usuario usuario;
    private String categoria;
    private double valor;

    public ServicoDTO(Servico servico) {
        this.titulo = servico.getTitulo();
        this.descricao = servico.getDescricao();
        this.usuario = servico.getUsuario();
        this.categoria = servico.getCategoria();
        this.valor = servico.getValor();
    }

    public static List<ServicoDTO> converter(List<Servico> servicoList) {
        return servicoList.stream().map(ServicoDTO::new).collect(Collectors.toList());
    }
}
