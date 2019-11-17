package com.app.coad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.coad.entity.TipoSolicitacao;

@Repository
public interface TipoSolicitacaoRepository extends JpaRepository<TipoSolicitacao, Integer> {

}