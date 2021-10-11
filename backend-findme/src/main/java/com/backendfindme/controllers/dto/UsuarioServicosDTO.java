package com.backendfindme.controllers.dto;
import com.backendfindme.models.Usuario;
import com.backendfindme.repositories.UsuarioRepository;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class UsuarioServicosDTO {

    private List<ServicoDTO> servicos;

    public UsuarioServicosDTO(Usuario usuario) {
        this.servicos = new ArrayList<>();
        this.servicos.addAll(usuario.getServico().stream().map(ServicoDTO::new).collect(Collectors.toList()));
    }

    public static List<UsuarioServicosDTO> converter(List<Usuario> usuarioList) {
        return usuarioList.stream().map(UsuarioServicosDTO::new).collect(Collectors.toList());
    }
}
