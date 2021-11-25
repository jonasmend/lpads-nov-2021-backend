package br.edu.fema.spring.especie.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.edu.fema.spring.especie.DTO.EspecieDTO;
import br.edu.fema.spring.especie.FORM.EspecieFORM;
import br.edu.fema.spring.especie.Model.Especie;
import br.edu.fema.spring.especie.Repository.EspecieRepository;

@Service
public class EspecieService {
	
	@Autowired
	private EspecieRepository especieRepository;
	
	public Especie atualizar(Integer id, EspecieFORM obj) {
	     Especie especie = this.especieRepository.getOne(id);
	     especie.setDescricao(obj.getDescricao());;
	    return especie;
	}
	
	public Especie converter(EspecieFORM especieFORM) {
		
		return new Especie(especieFORM.getId(), especieFORM.getDescricao());
	}
	
	public static Page<EspecieDTO> converter(Page<Especie> especies) {
		return especies.map(EspecieDTO::new);
	}

}
