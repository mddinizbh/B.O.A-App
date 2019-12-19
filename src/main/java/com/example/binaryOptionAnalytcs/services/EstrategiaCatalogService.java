package com.example.binaryOptionAnalytcs.services;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.binaryOptionAnalytcs.dto.EstrategiaCatalogDTO;
import com.example.binaryOptionAnalytcs.entities.EstrategiaCatalog;
import com.example.binaryOptionAnalytcs.repositories.EstrategiaCatalogRepository;
import com.example.binaryOptionAnalytcs.services.exceptions.DataIntegrityException;
import com.example.binaryOptionAnalytcs.services.exceptions.ObjectNotFoundException;

@Service
public class EstrategiaCatalogService {
	
	@Autowired
	EstrategiaCatalogRepository repository;
	
	
	public List<EstrategiaCatalog> findAll(){
		List <EstrategiaCatalog> estrategiaCatalogs = repository.findAll();
		
		return estrategiaCatalogs;
	}
	
	public EstrategiaCatalog findById(Long id) {
		Optional<EstrategiaCatalog> estrategiaCatalog = repository.findById(id);
		

		return estrategiaCatalog.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + EstrategiaCatalog.class.getName()));
		
	}
	
	public Page<EstrategiaCatalog> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),
				orderBy);
		
		return repository.findAll(pageRequest);
	}
	public EstrategiaCatalog insert(EstrategiaCatalog obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public EstrategiaCatalog update(EstrategiaCatalog obj) {
	
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
	
	
	public EstrategiaCatalog fromDTO(EstrategiaCatalogDTO dto) {
		
		return new EstrategiaCatalog(dto.getId(),dto.getQtdOperacaoes(), dto.getQtdWin(),dto.getQtdLose(), dto.getQtdMG(),dto.getQtdMGs());
	}

}
