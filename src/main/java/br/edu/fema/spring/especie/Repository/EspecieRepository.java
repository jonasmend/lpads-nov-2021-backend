package br.edu.fema.spring.especie.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fema.spring.especie.Model.Especie;

public interface EspecieRepository extends JpaRepository<Especie, Integer> {
	
	Page<Especie> findById(Integer id, Pageable paginacao);
	
	Especie findByDescricao(String especieDescricao);
	
	Especie findById(int especieId);
}
