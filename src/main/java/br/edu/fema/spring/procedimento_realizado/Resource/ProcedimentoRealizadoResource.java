package br.edu.fema.spring.procedimento_realizado.Resource;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.edu.fema.spring.procedimento.Model.Procedimento;
import br.edu.fema.spring.procedimento.Repository.ProcedimentoRepository;
import br.edu.fema.spring.procedimento_realizado.DTO.ProcedimentoRealizadoDTO;
import br.edu.fema.spring.procedimento_realizado.FORM.ATT_ProcedimentoRealizadoFORM;
import br.edu.fema.spring.procedimento_realizado.FORM.ProcedimentoRealizadoFORM;
import br.edu.fema.spring.procedimento_realizado.Model.ProcedimentoRealizado;
import br.edu.fema.spring.procedimento_realizado.Repository.ProcedimentoRealizadoRepository;
import br.edu.fema.spring.procedimento_realizado.Service.ProcedimentoRealizadoService;

@RestController
@RequestMapping("/procedimento-realizado")
public class ProcedimentoRealizadoResource {
	
	@Autowired
	ProcedimentoRealizadoRepository procedimentoRepository;
	
	@Autowired
	ProcedimentoRealizadoService procedimentoService;
	
	@Autowired
	ProcedimentoRepository procedimentoPadraoRepository;

	@GetMapping
	public Page<ProcedimentoRealizadoDTO> listagem(@RequestParam(required = false) Integer id, @PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {
		if(id == null) {
			Page<ProcedimentoRealizado> procedimentos = procedimentoRepository.findAll(paginacao);
			return ProcedimentoRealizadoService.converter(procedimentos);
		} else {
			Page<ProcedimentoRealizado> procedimentos = procedimentoRepository.findById(id, paginacao);
			return ProcedimentoRealizadoService.converter(procedimentos);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProcedimentoRealizadoDTO> detalhar(@PathVariable Integer id) {
		Optional<ProcedimentoRealizado> procedimento = procedimentoRepository.findById(id);
		if (procedimento.isPresent()) {
			return ResponseEntity.ok(new ProcedimentoRealizadoDTO(procedimento.get()));
		}
		
		return ResponseEntity.ok(new ProcedimentoRealizadoDTO(procedimento.get()));
	}
	
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional
	public ResponseEntity<ProcedimentoRealizadoDTO> cadastrar(@RequestBody @Valid ProcedimentoRealizadoFORM form, UriComponentsBuilder uriBuilder) {
		ProcedimentoRealizado procedimento = procedimentoService.converter(form);
		procedimentoRepository.save(procedimento);
		
		URI uri = uriBuilder.path("/procedimento-realizado/{id}").buildAndExpand(procedimento.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProcedimentoRealizadoDTO(procedimento));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ProcedimentoRealizadoDTO> atualizar(@PathVariable Integer id, @RequestBody @Valid ATT_ProcedimentoRealizadoFORM form) {
		Optional<ProcedimentoRealizado> optional = procedimentoRepository.findById(id);
		if(optional.isPresent()) {
			return ResponseEntity.ok(new ProcedimentoRealizadoDTO(this.procedimentoService.atualizar(id, form)));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Integer id) {
		Optional<ProcedimentoRealizado> optional = procedimentoRepository.findById(id);
		if(optional.isPresent()) {
			procedimentoService.deletar(id);
			procedimentoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
