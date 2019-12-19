package com.example.binaryOptionAnalytcs.services;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.binaryOptionAnalytcs.dto.CatalogacaoDTO;
import com.example.binaryOptionAnalytcs.entities.Catalogacao;
import com.example.binaryOptionAnalytcs.repositories.CatalogacaoRepository;
import com.example.binaryOptionAnalytcs.services.exceptions.DataIntegrityException;
import com.example.binaryOptionAnalytcs.services.exceptions.ObjectNotFoundException;

@Service
public class CatalogacaoService {
	
	@Autowired
	CatalogacaoRepository repository;
	
	
	public List<Catalogacao> findAll(){
		List <Catalogacao> catalogacaos =repository.findAll();
		
		return catalogacaos;
	}
	
	public Catalogacao findById(Long id) {
		Optional<Catalogacao> catalogacao =repository.findById(id);
		
		return catalogacao.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Catalogacao.class.getName()));
	}
	
	public Page<Catalogacao> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),
				orderBy);
		
		return repository.findAll(pageRequest);
	}
	public Catalogacao insert(Catalogacao obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Catalogacao update(Catalogacao obj) {
	
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
	
	public Catalogacao fromDTO(CatalogacaoDTO dto) {
		
		return new Catalogacao(dto.getId(), dto.getNome(), dto.getData(), dto.getHoraInicioCatalog(), dto.getHorafimCatalog());
	}

}
