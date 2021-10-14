package com.backendfindme.controllers.dto;

import com.backendfindme.models.Servico;
import com.backendfindme.models.TransacaoServico;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class TransacaoServicoContratadoDTO {

    private Servico servico;
    private Servico usuario_prestador;
    private String data_servico;
    private double valor_total;

    public TransacaoServicoContratadoDTO(TransacaoServico transacaoServico){
        this.servico = transacaoServico.getServico();
        this.usuario_prestador = transacaoServico.getUsuario_prestador();
        this.data_servico = transacaoServico.getData_servico();
        this.valor_total = transacaoServico.getValor_total();
    }

    public static List<TransacaoServicoContratadoDTO> converter(List<TransacaoServico> transacaoservicoList) {
        return transacaoservicoList.stream().map(TransacaoServicoContratadoDTO::new).collect(Collectors.toList());
    }

}
