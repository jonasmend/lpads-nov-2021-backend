package br.edu.fema.spring.procedimento_realizado.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fema.spring.procedimento_realizado.Model.ProcedimentoRealizado;

public interface ProcedimentoRealizadoRepository extends JpaRepository<ProcedimentoRealizado, Integer> {
	
	Page<ProcedimentoRealizado> findById(Integer id, Pageable paginacao);
	
	Optional<ProcedimentoRealizado> findById(Integer id);
	
	List<ProcedimentoRealizado> findByFichaAtendimentoId(Integer id);
	
	void deleteByFichaAtendimentoId(Integer id);

}
