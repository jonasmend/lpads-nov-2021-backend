package br.edu.fema.spring.procedimento.Repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fema.spring.procedimento.Model.Procedimento;

public interface ProcedimentoRepository extends JpaRepository<Procedimento, Integer> {
	
	Page<Procedimento> findById(Integer id, Pageable paginacao);
	
	Optional<Procedimento> findById(Integer id);

}
