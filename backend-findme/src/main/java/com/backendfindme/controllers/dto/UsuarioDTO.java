package com.backendfindme.controllers.dto;

import com.backendfindme.models.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class UsuarioDTO {

    private String nome;
    private String email;
    private String cidade;
    private String sigla_estado;
    private int pontuacao;

    public UsuarioDTO (Usuario usuario){
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.cidade = usuario.getCidade();
        this.sigla_estado = usuario.getSigla_estado();
        this.pontuacao = usuario.getPontuacao();
    }

    public static List<UsuarioDTO> converter(List<Usuario> usuarioList) {
        return usuarioList.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

}
