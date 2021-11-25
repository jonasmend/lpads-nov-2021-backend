package br.edu.fema.spring.procedimento.Service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.edu.fema.spring.procedimento.DTO.ProcedimentoDTO;
import br.edu.fema.spring.procedimento.FORM.ProcedimentoFORM;
import br.edu.fema.spring.procedimento.Model.Procedimento;
import br.edu.fema.spring.procedimento.Repository.ProcedimentoRepository;

@Service
public class ProcedimentoService {
	
	@Autowired
	ProcedimentoRepository procedimentoRepository;

	
	public Procedimento atualizar(Integer id, ProcedimentoFORM obj) {
	     Procedimento procedimento = this.procedimentoRepository.getOne(id);
	     if(obj.getValor().compareTo(new BigDecimal("0")) != 0) {
	    	 procedimento.setValor(obj.getValor()); 
	     }
	     if(obj.getDescricao() != "" && obj.getDescricao() != null) {
	    	 procedimento.setDescricao(obj.getDescricao()); 
	     }
	     if(obj.getEstoque() != null) {
	    	 procedimento.setEstoque(obj.getEstoque()); 
	     }
	    return procedimento;
	}
	
	public Procedimento converter(ProcedimentoFORM procedimentoFORM) {
		
		return new Procedimento(procedimentoFORM.getId(), procedimentoFORM.getValor(), procedimentoFORM.getDescricao(), procedimentoFORM.getEstoque());
	}
	
	public static Page<ProcedimentoDTO> converter(Page<Procedimento> procedimentos) {
		return procedimentos.map(ProcedimentoDTO::new);
	}
}
