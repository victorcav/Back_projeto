package com.backendfindme.repositories;

import com.backendfindme.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Transactional
    @Modifying
    @Query("update Usuario u set u.situacao = false where u.id = :id")
    void alteraSituacao (@Param("id") Long id);

}
