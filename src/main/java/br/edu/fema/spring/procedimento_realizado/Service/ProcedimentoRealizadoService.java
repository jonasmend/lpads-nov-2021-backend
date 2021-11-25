package br.edu.fema.spring.procedimento_realizado.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.javamoney.moneta.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.edu.fema.spring.ficha_atendimento.Model.FichaAtendimento;
import br.edu.fema.spring.ficha_atendimento.Repository.FichaAtendimentoRepository;
import br.edu.fema.spring.procedimento.Model.Procedimento;
import br.edu.fema.spring.procedimento.Repository.ProcedimentoRepository;
import br.edu.fema.spring.procedimento_realizado.DTO.ProcedimentoRealizadoDTO;
import br.edu.fema.spring.procedimento_realizado.FORM.ATT_ProcedimentoRealizadoFORM;
import br.edu.fema.spring.procedimento_realizado.FORM.ProcedimentoRealizadoFORM;
import br.edu.fema.spring.procedimento_realizado.Model.ProcedimentoRealizado;
import br.edu.fema.spring.procedimento_realizado.Repository.ProcedimentoRealizadoRepository;

@Service
public class ProcedimentoRealizadoService {
	
	@Autowired
	ProcedimentoRealizadoRepository procedimentoRepository;
	
	@Autowired
	FichaAtendimentoRepository fichaRepository;
	
	@Autowired
	ProcedimentoRepository procedimentoPadraoRepository;
	
	
	// List<Procedimento> procedimentoA = new ArrayList<Procedimento>();
	
	// List<Integer> procedimentoQuantidade = new ArrayList<Integer>();
	
	public ProcedimentoRealizado atualizar(Integer id, ATT_ProcedimentoRealizadoFORM obj/*, ProcedimentoRepository procedimentoPadraoRepository*/) {
	     ProcedimentoRealizado procedimentoRealizado = this.procedimentoRepository.getOne(id);
	     
	     Optional<FichaAtendimento> oFichaAtendimento = fichaRepository.findById(procedimentoRealizado.getFichaAtendimento().getId());
    	 FichaAtendimento fichaAtendimento = oFichaAtendimento.get();
    	 
    	 if(fichaAtendimento.getFinalizado() != 'S') {
    	 
		     Optional<Procedimento> oProcedimentoPadrao = procedimentoPadraoRepository.findById(procedimentoRealizado.getProcedimento().getId());
		     
		     if(obj.getProcedimento() != null && obj.getProcedimento().getId() != procedimentoRealizado.getProcedimento().getId()) {
		    	 
		    	 if(fichaAtendimento.getAnimal().getCliente().getConvenio() == 'N') {
		    		 fichaAtendimento.setTotal( fichaAtendimento.getTotal().subtract(oProcedimentoPadrao.get().getValor().multiply(new BigDecimal(procedimentoRealizado.getQuantidade()))).setScale(2, BigDecimal.ROUND_HALF_UP));
		    	 } else {
		    		 fichaAtendimento.setTotal(fichaAtendimento.getTotal().subtract((oProcedimentoPadrao.get().getValor().multiply(new BigDecimal(procedimentoRealizado.getQuantidade()))).multiply(new BigDecimal(0.85))).setScale(2, BigDecimal.ROUND_HALF_UP));
		    	 }
		    	 
		    	 //oProcedimentoPadrao = procedimentoPadraoRepository.findById(obj.getProcedimento().getId());
		    	 //Procedimento procedimentoPadrao = oProcedimentoPadrao.get();
		    	 
		    	 // this.procedimentoA.add(procedimentoPadrao); // = procedimento + procedimentoPadrao;
		    	 procedimentoRealizado.setProcedimento(obj.getProcedimento());
		    	 
		    	 procedimentoRealizado.setQuantidade(0);
		     }
	
	    	 
	    	 if(obj.getQuantidade() != 0) {
		    	 // procedimentoQuantidade.add(obj.getQuantidade());
		    	 procedimentoRealizado.setQuantidade(procedimentoRealizado.getQuantidade() + obj.getQuantidade());
		    	 // procedimentoRealizado.setTotal(oProcedimentoPadrao.get().getValor().multiply(new BigDecimal(procedimentoRealizado.getQuantidade())));
	    	 }
	    	 
	    	 procedimentoRealizado.setTotal(oProcedimentoPadrao.get().getValor().multiply(new BigDecimal(procedimentoRealizado.getQuantidade())));
	    	 
	    	 
	    	 if(fichaAtendimento.getAnimal().getCliente().getConvenio() == 'N') {
	    		 fichaAtendimento.setTotal(fichaAtendimento.getTotal().add(procedimentoRealizado.getProcedimento().getValor()).setScale(2, BigDecimal.ROUND_HALF_UP));
	    	 } else {
	    		 fichaAtendimento.setTotal(fichaAtendimento.getTotal().add(procedimentoRealizado.getProcedimento().getValor().multiply(new BigDecimal(0.85))).setScale(2, BigDecimal.ROUND_HALF_UP));
	    	 }
		}     	 
	    return procedimentoRealizado;
	}
	
	public ProcedimentoRealizado converter(ProcedimentoRealizadoFORM procedimentoFORM) {
		//Optional<FichaAtendimento> oFicha = fichaRepository.findById(procedimentoFORM.getFichaAtendimentoId());
		//FichaAtendimento ficha = oFicha.get();
		
		//Optional<Procedimento> oProcedimento = procedimentoPadraoRepository.findById(procedimentoFORM.getProcedimentoId());
		//Procedimento procedimento = oProcedimento.get();
		
		if(procedimentoFORM.getQuantidade() != 0) {
			procedimentoFORM.setTotal(procedimentoFORM.getProcedimento().getValor().multiply(new BigDecimal(procedimentoFORM.getQuantidade())));
			
			if(procedimentoFORM.getFichaAtendimento().getAnimal().getCliente().getConvenio() == 'N') {
				procedimentoFORM.getFichaAtendimento().setTotal( procedimentoFORM.getFichaAtendimento().getTotal().subtract(procedimentoFORM.getProcedimento().getValor().multiply(new BigDecimal(procedimentoFORM.getQuantidade()))).setScale(2, BigDecimal.ROUND_HALF_UP));
	    	 } else {
	    		 procedimentoFORM.getFichaAtendimento().setTotal(procedimentoFORM.getFichaAtendimento().getTotal().subtract((procedimentoFORM.getProcedimento().getValor().multiply(new BigDecimal(procedimentoFORM.getQuantidade()))).multiply(new BigDecimal(0.85))).setScale(2, BigDecimal.ROUND_HALF_UP));
	    	 }
		}
		
		return new ProcedimentoRealizado(procedimentoFORM.getId(), procedimentoFORM.getFichaAtendimento(), procedimentoFORM.getProcedimento(), procedimentoFORM.getQuantidade(), procedimentoFORM.getTotal());
	}
	
	public ProcedimentoRealizado deletar(Integer id) {
		ProcedimentoRealizado procedimentoRealizado = this.procedimentoRepository.getOne(id);
		
		Optional<FichaAtendimento> oFichaAtendimento = fichaRepository.findById(procedimentoRealizado.getFichaAtendimento().getId());
   	 	FichaAtendimento fichaAtendimento = oFichaAtendimento.get();
   	 	
   	 	if(fichaAtendimento.getAnimal().getCliente().getConvenio() == 'N') {
   	 		fichaAtendimento.setTotal(fichaAtendimento.getTotal().subtract(procedimentoRealizado.getTotal()));
   	 	} else {
   	 		fichaAtendimento.setTotal(fichaAtendimento.getTotal().subtract(procedimentoRealizado.getTotal().multiply(new BigDecimal(0.85))));
   	 	}
		
		
		return null;
	}
	
	public static Page<ProcedimentoRealizadoDTO> converter(Page<ProcedimentoRealizado> procedimentos) {
		return procedimentos.map(ProcedimentoRealizadoDTO::new);
	}

}
