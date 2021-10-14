package com.backendfindme.controllers.dto;

import com.backendfindme.models.Servico;
import com.backendfindme.models.TransacaoServico;
import com.backendfindme.models.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class TransacaoServicoPrestadoDTO {

    private Servico servico;
    private Usuario usuario_contratante;
    private String data_servico;
    private double valor_total;

    public TransacaoServicoPrestadoDTO(TransacaoServico transacaoServico){
        this.servico = transacaoServico.getServico();
        this.usuario_contratante = transacaoServico.getUsuario_contratante();
        this.data_servico = transacaoServico.getData_servico();
        this.valor_total = transacaoServico.getValor_total();
    }

    public static List<TransacaoServicoPrestadoDTO> converter(List<TransacaoServico> transacaoservicoList) {
        return transacaoservicoList.stream().map(TransacaoServicoPrestadoDTO::new).collect(Collectors.toList());
    }

}
