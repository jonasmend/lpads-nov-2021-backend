package br.edu.fema.spring.procedimento.Resource;

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

import br.edu.fema.spring.procedimento.DTO.ProcedimentoDTO;
import br.edu.fema.spring.procedimento.FORM.ProcedimentoFORM;
import br.edu.fema.spring.procedimento.Model.Procedimento;
import br.edu.fema.spring.procedimento.Repository.ProcedimentoRepository;
import br.edu.fema.spring.procedimento.Service.ProcedimentoService;

@RestController
@RequestMapping("/procedimento")
public class ProcedimentoResource {
	
	@Autowired
	ProcedimentoRepository procedimentoRepository;
	
	@Autowired
	ProcedimentoService procedimentoService;
	
	@GetMapping
	public Page<ProcedimentoDTO> listagem(@RequestParam(required = false) Integer id, @PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {
		if (id == null) {
			Page<Procedimento> procedimentos = procedimentoRepository.findAll(paginacao);
			return ProcedimentoService.converter(procedimentos);
		} else {
			Page<Procedimento> procedimentos = procedimentoRepository.findById(id, paginacao);
			return ProcedimentoService.converter(procedimentos);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProcedimentoDTO> detalhar(@PathVariable Integer id) {
		Optional<Procedimento> procedimento = procedimentoRepository.findById(id);
		if (procedimento.isPresent()) {
			return ResponseEntity.ok(new ProcedimentoDTO(procedimento.get()));
		}
		
		return ResponseEntity.ok(new ProcedimentoDTO(procedimento.get()));
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<ProcedimentoDTO> cadastrar(@RequestBody @Valid ProcedimentoFORM form, UriComponentsBuilder uriBuilder) {
		Procedimento procedimento = procedimentoService.converter(form);
		procedimentoRepository.save(procedimento);
		
		URI uri = uriBuilder.path("/procedimento/{id}").buildAndExpand(procedimento.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProcedimentoDTO(procedimento));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ProcedimentoDTO> atualizar(@PathVariable Integer id, @RequestBody @Valid ProcedimentoFORM form) {
		Optional<Procedimento> optional = procedimentoRepository.findById(id);
		if(optional.isPresent()) {
			return ResponseEntity.ok(new ProcedimentoDTO(this.procedimentoService.atualizar(id, form)));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Integer id) {
		Optional<Procedimento> optional = procedimentoRepository.findById(id);
		if(optional.isPresent()) {
			procedimentoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

}
