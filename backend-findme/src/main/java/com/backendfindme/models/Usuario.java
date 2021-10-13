package com.backendfindme.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String email;

    @Column
    private String senha;

    @Column
    private String cpf_cnpj;

    @Column
    private String telefone;

    @Column
    private String cep;

    @Column
    private String endereco;

    @Column
    private String cidade;

    @Column
    private String sigla_estado;

    @Column
    private int numero;

    @Column
    private int pontuacao = 50;

    @Column
    private boolean situacao = true;


    @OneToMany(mappedBy = "usuario")
    private List<Servico> servico = new ArrayList<>();


    @OneToMany(mappedBy = "usuario_contratante")
    private List<TransacaoServico> transacaoServicoContratados = new ArrayList<>();



    public Usuario(String nome, String email, String senha, String cpf_cnpj, String telefone, String cep,
                   String endereco, String cidade, String sigla_estado, int numero) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf_cnpj = cpf_cnpj;
        this.telefone = telefone;
        this.cep = cep;
        this.endereco = endereco;
        this.cidade = cidade;
        this.sigla_estado = sigla_estado;
        this.numero = numero;
    }

}
