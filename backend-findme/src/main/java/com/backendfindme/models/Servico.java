package com.backendfindme.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "servico")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String titulo;

    @Column
    private String descricao;

    @Column
    private String categoria;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column
    private double valor;

    @Column
    private boolean situacao = true;

    @OneToMany(mappedBy = "servico")
    private List<TransacaoServico> transacaoServico= new ArrayList<>();

    @OneToMany(mappedBy = "usuario_prestador")
    private List<TransacaoServico> transacaoServicoPrestados = new ArrayList<>();

    public Servico(String titulo, String descricao, String categoria,Usuario usuario, double valor) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.usuario = usuario;
        this.valor = valor;
    }
}
