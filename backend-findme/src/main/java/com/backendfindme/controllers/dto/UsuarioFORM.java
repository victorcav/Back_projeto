package com.backendfindme.controllers.dto;

import com.backendfindme.models.Usuario;
import com.backendfindme.repositories.UsuarioRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioFORM {

    private String nome;
    private String email;
    private String senha;
    private String cpf_cnpj;
    private String telefone;
    private String cep;
    private String endereco;
    private String cidade;
    private String sigla_estado;
    private int numero;

    public Usuario converter(UsuarioRepository usuarioRepository){
        return new Usuario(nome, email, senha, cpf_cnpj, telefone, cep,
                           endereco, cidade, sigla_estado, numero);
    }

}
