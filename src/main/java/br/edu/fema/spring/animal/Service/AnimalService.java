package br.edu.fema.spring.animal.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.edu.fema.spring.animal.DTO.AnimalDTO;
import br.edu.fema.spring.animal.FORM.ATT_AnimalFORM;
import br.edu.fema.spring.animal.FORM.AnimalFORM;
import br.edu.fema.spring.animal.Model.Animal;
import br.edu.fema.spring.animal.Repository.AnimalRepository;
import br.edu.fema.spring.cliente.Model.Cliente;
import br.edu.fema.spring.cliente.Repository.ClienteRepository;
import br.edu.fema.spring.especie.Model.Especie;
import br.edu.fema.spring.especie.Repository.EspecieRepository;

@Service
public class AnimalService {
	
	@Autowired
	private AnimalRepository animalRepository;
	
	public Animal atualizar(Integer id, ATT_AnimalFORM obj, ClienteRepository clienteRepository) {
		Animal animal = this.animalRepository.getOne(id);
		//Optional<Cliente> oCliente = clienteRepository.findById(obj.getClienteId());
		//Cliente cliente = oCliente.get();
		animal.setCliente(obj.getCliente());
		animal.setNome(obj.getNome());
		return animal;
	}
	
	public Animal converter(/*ClienteRepository clienteRepository, EspecieRepository especieRepository,*/ AnimalFORM animalFORM) {
		//Optional<Cliente> oCliente = clienteRepository.findById(animalFORM.getClienteId());
		//Cliente cliente = oCliente.get();
		//Optional<Especie> oEspecie = especieRepository.findById(animalFORM.getEspecieId());
		//Especie especie = oEspecie.get();
		return new Animal(animalFORM.getId(), animalFORM.getEspecie(), animalFORM.getCliente(), animalFORM.getNome(), animalFORM.getNascimento());
	}
	
	public static Page<AnimalDTO> converter(Page<Animal> animais) {
		return animais.map(AnimalDTO::new);
	}

}
