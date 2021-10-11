package com.backendfindme.repositories;

import com.backendfindme.models.TransacaoServico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoServicoRepository extends JpaRepository<TransacaoServico, Long> {
}
