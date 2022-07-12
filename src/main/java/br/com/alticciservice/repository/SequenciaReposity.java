package br.com.alticciservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alticciservice.domain.entity.Sequencia;

@Repository
public interface SequenciaReposity extends JpaRepository<Sequencia, Long>{

}
