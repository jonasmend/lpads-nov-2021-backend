package br.edu.fema.spring.especie.Resource;

import java.net.URI;
import java.util.Optional;

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

import br.edu.fema.spring.especie.DTO.EspecieDTO;
import br.edu.fema.spring.especie.FORM.EspecieFORM;
import br.edu.fema.spring.especie.Model.Especie;
import br.edu.fema.spring.especie.Repository.EspecieRepository;
import br.edu.fema.spring.especie.Service.EspecieService;

@RestController
@RequestMapping("/especie")
public class EspecieResource {
	
	@Autowired
	private EspecieRepository especieRepository;
	
	@Autowired
	private EspecieService especieService;
	
	@GetMapping
	public Page<EspecieDTO> listagem(@RequestParam(required = false) Integer id, @PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {
		if (id == null) {
			Page<Especie> especies = especieRepository.findAll(paginacao);
			return EspecieService.converter(especies);
		} else {
			Page<Especie> especies = especieRepository.findById(id, paginacao);
			return EspecieService.converter(especies);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EspecieDTO> detalhar(@PathVariable Integer id) {
		Optional<Especie> especie = especieRepository.findById(id);
		if (especie.isPresent()) {
			return ResponseEntity.ok(new EspecieDTO(especie.get()));
		}
		
		return ResponseEntity.ok(new EspecieDTO(especie.get()));
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<EspecieDTO> cadastrar(@RequestBody @Valid EspecieFORM form, UriComponentsBuilder uriBuilder) {
		Especie especie = especieService.converter(form);
		especieRepository.save(especie);
		
		URI uri = uriBuilder.path("/especie/{id}").buildAndExpand(especie.getId()).toUri();
		return ResponseEntity.created(uri).body(new EspecieDTO(especie));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<EspecieDTO> atualizar(@PathVariable Integer id, @RequestBody @Valid EspecieFORM form) {
		Optional<Especie> optional = especieRepository.findById(id);
		if(optional.isPresent()) {
			return ResponseEntity.ok(new EspecieDTO(this.especieService.atualizar(id, form)));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Integer id) {
		Optional<Especie> optional = especieRepository.findById(id);
		if(optional.isPresent()) {
			especieRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

}
