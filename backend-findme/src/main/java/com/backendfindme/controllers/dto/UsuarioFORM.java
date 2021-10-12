package com.backendfindme.controllers.dto;

import com.backendfindme.models.Usuario;
import com.backendfindme.repositories.UsuarioRepository;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UsuarioFORM {

    @NotNull
    @NotEmpty
    @NotBlank
    private String nome;

    @NotNull
    @NotEmpty
    @NotBlank
    private String email;

    @NotNull
    @NotEmpty
    @NotBlank
    private String senha;

    @NotNull
    @NotEmpty
    @NotBlank
    private String cpf_cnpj;

    @NotNull
    @NotEmpty
    @NotBlank
    private String telefone;

    @NotNull
    @NotEmpty
    @NotBlank
    private String cep;

    @NotNull
    @NotEmpty
    @NotBlank
    private String endereco;

    @NotNull
    @NotEmpty
    @NotBlank
    private String cidade;

    @NotNull
    @NotEmpty
    @NotBlank
    private String sigla_estado;

    @NotNull
    @NotEmpty
    @NotBlank
    private int numero;

    public Usuario converter(UsuarioRepository usuarioRepository){
        return new Usuario(nome, email, senha, cpf_cnpj, telefone, cep,
                           endereco, cidade, sigla_estado, numero);
    }

}
