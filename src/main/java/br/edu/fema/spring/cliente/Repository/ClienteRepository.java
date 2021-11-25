package br.edu.fema.spring.cliente.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fema.spring.cliente.Model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	Page<Cliente> findById(Integer id, Pageable paginacao);

	// List<Cliente> findBynomeStartingWith(char letra);
	
	Optional<Cliente> findById(Integer clienteId);
	
}
