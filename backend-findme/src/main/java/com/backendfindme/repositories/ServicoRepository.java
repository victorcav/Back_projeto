package com.backendfindme.repositories;

import com.backendfindme.models.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ServicoRepository extends JpaRepository<Servico, Long> {

    List<Servico> findByCategoria(String nomeCategoria);

    @Query("select s from Servico s where categoria like %:nomeCategoria")
    List<Servico> filtrarPorCategoria(@Param("nomeCategoria") String nomeCategoria);

/*

    @Query("select s from Servico s where s.categoria = :nomeCategoria")
    List<Servico> filtrarPorCategoria(@Param("nomeCategoria") String nomeCategoria);

 */


    @Transactional
    @Modifying
    @Query("update Servico u set u.situacao = false where u.id = :id")
    void alteraSituacao (@Param("id") Long id);

}
