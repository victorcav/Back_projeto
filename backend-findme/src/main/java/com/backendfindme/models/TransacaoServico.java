package com.backendfindme.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "transacao_servico")
public class TransacaoServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_servico")
    private Servico servico;

    @ManyToOne
    @JoinColumn(name="id_usuario_contratante")
    private Usuario usuario_contratante;

    @ManyToOne
    @JoinColumn(name="id_usuario_prestador")
    private Servico usuario_prestador;

    @Column
    private String data_servico;

    @Column
    private int qtd_horas;

    @Column
    private double valor_total;

    @Column
    private boolean utiliza_pontos;

    @Column
    private int qtd_pontos;

}
