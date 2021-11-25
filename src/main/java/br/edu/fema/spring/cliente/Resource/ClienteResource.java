package br.edu.fema.spring.cliente.Resource;

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

import br.edu.fema.spring.cliente.Service.ClienteService;
import br.edu.fema.spring.cliente.DTO.ClienteDTO;
import br.edu.fema.spring.cliente.FORM.ATT_ClienteFORM;
import br.edu.fema.spring.cliente.FORM.ClienteFORM;
import br.edu.fema.spring.cliente.Model.Cliente;
import br.edu.fema.spring.cliente.Repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteResource {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public Page<ClienteDTO> listagem(@RequestParam(required = false) Integer id, @PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {
		if (id == null) {
			Page<Cliente> clientes = clienteRepository.findAll(paginacao);
			return ClienteService.converter(clientes);
		} else {
			Page<Cliente> clientes = clienteRepository.findById(id, paginacao);
			return ClienteService.converter(clientes);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteDTO> detalhar(@PathVariable Integer id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (cliente.isPresent()) {
			return ResponseEntity.ok(new ClienteDTO(cliente.get()));
		}
		
		return ResponseEntity.ok(new ClienteDTO(cliente.get()));
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<ClienteDTO> cadastrar(@RequestBody @Valid ClienteFORM form, UriComponentsBuilder uriBuilder) {
		Cliente cliente = clienteService.converter(form);
		clienteRepository.save(cliente);
		
		URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteDTO(cliente));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ClienteDTO> atualizar(@PathVariable Integer id, @RequestBody @Valid ATT_ClienteFORM form) {
		Optional<Cliente> optional = clienteRepository.findById(id);
		if(optional.isPresent()) {
			return ResponseEntity.ok(new ClienteDTO(this.clienteService.atualizar(id, form)));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Integer id) {
		Optional<Cliente> optional = clienteRepository.findById(id);
		if(optional.isPresent()) {
			clienteRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

}
