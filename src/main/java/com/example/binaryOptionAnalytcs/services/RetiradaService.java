package com.example.binaryOptionAnalytcs.services;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.binaryOptionAnalytcs.dto.RetiradaDTO;
import com.example.binaryOptionAnalytcs.entities.Retirada;
import com.example.binaryOptionAnalytcs.repositories.RetiradaRepository;
import com.example.binaryOptionAnalytcs.services.exceptions.DataIntegrityException;
import com.example.binaryOptionAnalytcs.services.exceptions.ObjectNotFoundException;

@Service
public class RetiradaService {
	
	@Autowired
	RetiradaRepository repository;
	
	
	public List<Retirada> findAll(){
		List <Retirada> retiradas = repository.findAll();
		
		return retiradas;
	}
	
	public Retirada findById(Long id) {
		Optional<Retirada> retirada = repository.findById(id);
		
		return retirada.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Retirada.class.getName()));
		
	}
	
	public Page<Retirada> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),
				orderBy);
		
		return repository.findAll(pageRequest);
	}
	public Retirada insert(Retirada obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Retirada update(Retirada obj) {
	
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
	
	public Retirada fromDTO(RetiradaDTO dto) {
		
		return new Retirada(dto.getValorRetirada(), dto.getDataRetirada(), dto.getDescricao());
	}


}
