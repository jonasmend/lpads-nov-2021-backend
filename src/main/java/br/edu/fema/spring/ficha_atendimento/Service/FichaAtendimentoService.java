package br.edu.fema.spring.ficha_atendimento.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.edu.fema.spring.animal.Model.Animal;
import br.edu.fema.spring.animal.Repository.AnimalRepository;
import br.edu.fema.spring.ficha_atendimento.DTO.FichaAtendimentoDTO;
import br.edu.fema.spring.ficha_atendimento.FORM.ATT_FichaAtendimentoFORM;
import br.edu.fema.spring.ficha_atendimento.FORM.FichaAtendimentoFORM;
import br.edu.fema.spring.ficha_atendimento.Model.FichaAtendimento;
import br.edu.fema.spring.ficha_atendimento.Repository.FichaAtendimentoRepository;
import br.edu.fema.spring.procedimento_realizado.Model.ProcedimentoRealizado;
import br.edu.fema.spring.procedimento_realizado.Repository.ProcedimentoRealizadoRepository;

@Service
public class FichaAtendimentoService {

	@Autowired
	FichaAtendimentoRepository fichaRepository;
	
	@Autowired
	ProcedimentoRealizadoRepository procedimentoRepository;

	
	public FichaAtendimento atualizar(Integer id, ATT_FichaAtendimentoFORM obj) {
		FichaAtendimento fichaAtendimento = this.fichaRepository.getOne(id);
		if(fichaAtendimento.getFinalizado() == 'N') {
			// FichaAtendimento fichaAtendimento = this.fichaRepository.getOne(id);
	    		fichaAtendimento.setFinalizado(obj.getFinalizado()); 
	    	/*if(obj.getTotal() != 0) {
	    	 	fichaAtendimento.setTotal(obj.getTotal()); 
	     	}*/
	    	// return fichaAtendimento;
		}
		return fichaAtendimento;
	}
	
	public FichaAtendimento converter(FichaAtendimentoFORM fichaFORM/*, AnimalRepository animalRepository*/) {
		//Optional<Animal> oAnimal = animalRepository.findById(fichaFORM.getAnimalId());
		//Animal animal = oAnimal.get();
		return new FichaAtendimento(fichaFORM.getId(), fichaFORM.getAnimal(), fichaFORM.getDataAtendimento());
	}
	
	/*
	public FichaAtendimento deletar(Integer id) {
		FichaAtendimento fichaAtendimento = this.fichaRepository.getOne(id);
		Optional<ProcedimentoRealizado> oProcedimento = procedimentoRepository.findOneByFichaAtendimentoId(fichaAtendimento.getId());
		ProcedimentoRealizado procedimento;
		
		do {
		procedimento = oProcedimento.get();
		procedimentoRepository.deleteById(procedimento.getId());
		oProcedimento = procedimentoRepository.findOneByFichaAtendimentoId(fichaAtendimento.getId());
		} while(oProcedimento.isPresent());
		
		return null;
	}
	*/
	
	public static Page<FichaAtendimentoDTO> converter(Page<FichaAtendimento> fichas) {
		return fichas.map(FichaAtendimentoDTO::new);
	}
}
