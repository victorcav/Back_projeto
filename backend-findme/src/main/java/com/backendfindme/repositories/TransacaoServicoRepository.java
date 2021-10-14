package com.backendfindme.repositories;

import com.backendfindme.models.TransacaoServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransacaoServicoRepository extends JpaRepository<TransacaoServico, Long> {

    @Query("select t from TransacaoServico t where t.usuario_contratante.id = :meuIdContratante")
    List<TransacaoServico> listarTransacaoServicoContratadas(@Param("meuIdContratante") Long meuIdContratante);

    @Query("select t from TransacaoServico t where t.usuario_prestador.id = :meuIdPrestador")
    List<TransacaoServico> listarTransacaoServicoPrestadas(@Param("meuIdPrestador") Long meuIdPrestador);

}
