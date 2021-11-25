package br.edu.fema.spring.animal.Repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fema.spring.animal.Model.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

	Page<Animal> findById(Integer id, Pageable paginacao);
	
	Optional<Animal> findById(Integer id);
	
}
