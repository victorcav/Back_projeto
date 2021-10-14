package com.backendfindme.controllers.dto;

import com.backendfindme.models.Categoria;
import com.backendfindme.models.Servico;
import com.backendfindme.models.Usuario;
import com.backendfindme.repositories.ServicoRepository;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ServicoFORM {

    @NotNull
    @NotEmpty
    @NotBlank
    private String titulo;

    @NotNull
    @NotEmpty
    @NotBlank
    private String descricao;

    @NotNull
    @NotEmpty
    @NotBlank
    private Categoria categoria;

    @NotNull
    @NotEmpty
    @NotBlank
    private double valor;

    private Usuario usuario;

    public Servico converter(ServicoRepository servicoRepository){
        return new Servico(titulo, descricao, categoria, usuario, valor);
    }
}
