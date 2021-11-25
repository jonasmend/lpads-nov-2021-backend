package br.edu.fema.spring.ficha_atendimento.Repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fema.spring.ficha_atendimento.Model.FichaAtendimento;

public interface FichaAtendimentoRepository extends JpaRepository<FichaAtendimento, Integer> {
	
	Page<FichaAtendimento> findById(Integer id, Pageable paginacao);
	
	Optional<FichaAtendimento> findById(Integer id);

}
