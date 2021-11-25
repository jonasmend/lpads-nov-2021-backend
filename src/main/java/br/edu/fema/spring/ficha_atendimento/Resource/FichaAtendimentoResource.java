package br.edu.fema.spring.ficha_atendimento.Resource;

import java.net.URI;
import java.util.List;
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

import br.edu.fema.spring.animal.Repository.AnimalRepository;
import br.edu.fema.spring.ficha_atendimento.DTO.FichaAtendimentoDTO;
import br.edu.fema.spring.ficha_atendimento.FORM.ATT_FichaAtendimentoFORM;
import br.edu.fema.spring.ficha_atendimento.FORM.FichaAtendimentoFORM;
import br.edu.fema.spring.ficha_atendimento.Model.FichaAtendimento;
import br.edu.fema.spring.ficha_atendimento.Repository.FichaAtendimentoRepository;
import br.edu.fema.spring.ficha_atendimento.Service.FichaAtendimentoService;
import br.edu.fema.spring.procedimento_realizado.Model.ProcedimentoRealizado;
import br.edu.fema.spring.procedimento_realizado.Repository.ProcedimentoRealizadoRepository;

@RestController
@RequestMapping("/ficha-atendimento")
public class FichaAtendimentoResource {
	
	@Autowired
	FichaAtendimentoRepository fichaRepository;
	
	@Autowired
	AnimalRepository animalRepository;
	
	@Autowired
	ProcedimentoRealizadoRepository procedimentoRepository;
	
	@Autowired
	FichaAtendimentoService fichaService;
	
	@GetMapping
	public Page<FichaAtendimentoDTO> listagem(@RequestParam(required = false) Integer id, @PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {
		if(id == null) {
			Page<FichaAtendimento> fichas = fichaRepository.findAll(paginacao);
			return FichaAtendimentoService.converter(fichas);
		} else {
			Page<FichaAtendimento> fichas = fichaRepository.findById(id, paginacao);
			return FichaAtendimentoService.converter(fichas);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FichaAtendimentoDTO> detalhar(@PathVariable Integer id) {
		Optional<FichaAtendimento> ficha = fichaRepository.findById(id);
		if (ficha.isPresent()) {
			return ResponseEntity.ok(new FichaAtendimentoDTO(ficha.get()));
		}
		
		return ResponseEntity.ok(new FichaAtendimentoDTO(ficha.get()));
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<FichaAtendimentoDTO> cadastrar(@RequestBody @Valid FichaAtendimentoFORM form, UriComponentsBuilder uriBuilder) {
		FichaAtendimento ficha = fichaService.converter(form/*, animalRepository*/);
		fichaRepository.save(ficha);
		
		URI uri = uriBuilder.path("/ficha-atendimento/{id}").buildAndExpand(ficha.getId()).toUri();
		return ResponseEntity.created(uri).body(new FichaAtendimentoDTO(ficha));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<FichaAtendimentoDTO> atualizar(@PathVariable Integer id, @RequestBody @Valid ATT_FichaAtendimentoFORM form) {
		Optional<FichaAtendimento> optional = fichaRepository.findById(id);
		if(optional.isPresent()) {
			return ResponseEntity.ok(new FichaAtendimentoDTO(this.fichaService.atualizar(id, form)));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Integer id) {
		Optional<FichaAtendimento> optional = fichaRepository.findById(id);
		List<ProcedimentoRealizado> oProcedimento = procedimentoRepository.findByFichaAtendimentoId(id);
		
		if(oProcedimento.size() > 0) {
			// procedimentoRepository.deleteAllByFichaAtendimentoId(id);
			// fichaService.deletar(id);
			procedimentoRepository.deleteByFichaAtendimentoId(id);
			return ResponseEntity.noContent().build();
		} else if(optional.isPresent()) {
			fichaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

}
