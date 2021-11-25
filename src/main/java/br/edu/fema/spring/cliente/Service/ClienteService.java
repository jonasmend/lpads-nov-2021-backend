package br.edu.fema.spring.cliente.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.edu.fema.spring.cliente.DTO.ClienteDTO;
import br.edu.fema.spring.cliente.FORM.ATT_ClienteFORM;
import br.edu.fema.spring.cliente.FORM.ClienteFORM;
import br.edu.fema.spring.cliente.Model.Cliente;
import br.edu.fema.spring.cliente.Repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente atualizar(Integer id, ATT_ClienteFORM obj) {
	     Cliente cliente = this.clienteRepository.getOne(id);
	     cliente.setNome(obj.getNome());
	     cliente.setConvenio(obj.getConvenio());
	     cliente.setTelefone(obj.getTelefone());
	     cliente.setEmail(obj.getEmail());
	    return cliente;
	}
	
	public Cliente converter(ClienteFORM clienteFORM) {
		
		return new Cliente(clienteFORM.getId(), clienteFORM.getNome(), clienteFORM.getNascimento(), clienteFORM.getCpf(), clienteFORM.getConvenio(), clienteFORM.getTelefone(), clienteFORM.getEmail());
	}
	
	public static Page<ClienteDTO> converter(Page<Cliente> clientes) {
		return clientes.map(ClienteDTO::new);
	}
}
