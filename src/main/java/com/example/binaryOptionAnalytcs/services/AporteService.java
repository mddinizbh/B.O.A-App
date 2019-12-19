package com.example.binaryOptionAnalytcs.services;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.binaryOptionAnalytcs.dto.AporteDTO;
import com.example.binaryOptionAnalytcs.entities.Aporte;
import com.example.binaryOptionAnalytcs.repositories.AporteRepository;
import com.example.binaryOptionAnalytcs.services.exceptions.DataIntegrityException;
import com.example.binaryOptionAnalytcs.services.exceptions.ObjectNotFoundException;

@Service
public class AporteService {
	
	@Autowired
	AporteRepository repository;
	
	
	public List<Aporte> findAll(){
		List <Aporte> usuarios = repository.findAll();
		
		return usuarios;
	}
	
	public Aporte findById(Long id) {
		Optional<Aporte> aporte = repository.findById(id);
		
		return aporte.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Aporte.class.getName()));
		
	}
	
public Page<Aporte> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),
				orderBy);
		
		return repository.findAll(pageRequest);
	}
	public Aporte insert(Aporte obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Aporte update(Aporte obj) {
	
		findById(obj.getId());
		return repository.save(obj);
	}

	public void delete(Long id) {
		findById(id);
		try {
			repository.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel Deletar uma Estrategia que está relacionada a um Trade ou a uma Catalogação de Estrategia");
		}
	}
	
	public Aporte fromDTO(AporteDTO dto) {
		
		return new Aporte(dto.getId(),dto.getValorAporte(), dto.getDataAporte());
		
	}

}
