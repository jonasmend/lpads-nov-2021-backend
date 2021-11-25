package br.edu.fema.spring.animal.Resource;

import java.net.URI;
import java.util.Optional;

import javax.persistence.MappedSuperclass;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.edu.fema.spring.animal.DTO.AnimalDTO;
import br.edu.fema.spring.animal.FORM.ATT_AnimalFORM;
import br.edu.fema.spring.animal.FORM.AnimalFORM;
import br.edu.fema.spring.animal.Model.Animal;
import br.edu.fema.spring.animal.Repository.AnimalRepository;
import br.edu.fema.spring.animal.Service.AnimalService;
import br.edu.fema.spring.cliente.Repository.ClienteRepository;
import br.edu.fema.spring.especie.Repository.EspecieRepository;

@RestController
@RequestMapping("/animal")
public class AnimalResource {
	
	@Autowired
	private AnimalRepository animalRepository;

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EspecieRepository especieRepository;
	
	@Autowired
	private AnimalService animalService;
	
	@GetMapping
	public Page<AnimalDTO> listagem(@RequestParam(required = false) Integer idCategoria, @PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {
		if(idCategoria == null) {
			Page<Animal> animais = animalRepository.findAll(paginacao);
			return AnimalService.converter(animais);
		} else {
			Page<Animal> animais = animalRepository.findById(idCategoria, paginacao);
			return AnimalService.converter(animais);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AnimalDTO> detalhar(@PathVariable Integer id) {
		Optional<Animal> animal = animalRepository.findById(id);
		if (animal.isPresent()) {
			return ResponseEntity.ok(new AnimalDTO(animal.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<AnimalDTO> cadastrar(@RequestBody @Valid AnimalFORM form, UriComponentsBuilder uriBuilder) {
		Animal animal = animalService.converter(/*clienteRepository, especieRepository,*/ form);
		animalRepository.save(animal);
		
		URI uri = uriBuilder.path("/animal/{id}").buildAndExpand(animal.getId()).toUri();
		return ResponseEntity.created(uri).body(new AnimalDTO(animal));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<AnimalDTO> atualizar(@PathVariable Integer id, @RequestBody @Valid ATT_AnimalFORM form) {
		Optional<Animal> optional = animalRepository.findById(id);
		if(optional.isPresent()) {
			Animal animal = animalService.atualizar(id, form, clienteRepository);
			return ResponseEntity.ok(new AnimalDTO(animal));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Integer id) {
		Optional<Animal> optional = animalRepository.findById(id);
		if(optional.isPresent()) {
			animalRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
