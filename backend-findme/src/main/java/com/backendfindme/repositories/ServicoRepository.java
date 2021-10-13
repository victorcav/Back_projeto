package com.backendfindme.repositories;

import com.backendfindme.models.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServicoRepository extends JpaRepository<Servico, Long> {

/*

    @Query("select t from servico t where t.servico.categoria = :categoria")
    List<Servico> filtarPorCategoria(String categoria);

 */

}
