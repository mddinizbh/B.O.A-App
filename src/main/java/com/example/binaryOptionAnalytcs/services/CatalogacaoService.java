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
import com.example.binaryOptionAnalytcs.dto.CatalogacaoNewDTO;
import com.example.binaryOptionAnalytcs.entities.Catalogacao;
import com.example.binaryOptionAnalytcs.enuns.MensagensEnum;
import com.example.binaryOptionAnalytcs.repositories.CatalogacaoRepository;
import com.example.binaryOptionAnalytcs.repositories.MessageByLocaleRepository;
import com.example.binaryOptionAnalytcs.services.exceptions.DataIntegrityException;
import com.example.binaryOptionAnalytcs.services.exceptions.ObjectNotFoundException;

@Service
public class CatalogacaoService {
	
	@Autowired
	private CatalogacaoRepository repository;
	
	@Autowired
	private MessageByLocaleRepository messageSource;
	
	
	public List<Catalogacao> findAll(){
		List <Catalogacao> catalogacaos =repository.findAll();
		
		return catalogacaos;
	}
	
	public Catalogacao findById(Long id) {
		Optional<Catalogacao> catalogacao =repository.findById(id);
		
		Object [] args = new Object[10];
		args[0]=id;
		args[1]= Catalogacao.class.getName();
		
		String msg = messageSource.getMessage(MensagensEnum.TIPO_NAO_ENCONTRADO.getMenssagem(),args);
		
		return catalogacao.orElseThrow(() -> new ObjectNotFoundException(msg));
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
			throw new DataIntegrityException(messageSource.getMessage(MensagensEnum.ERRO_DELETAR_CATALOGACAO.getMenssagem()));
		}
	}
	
	public Catalogacao fromDTO(CatalogacaoDTO dto) {
		
		return new Catalogacao(dto.getId(), dto.getNome(), dto.getData(), dto.getHoraInicio(), dto.getHoraFim());
	}
	
	public Catalogacao fromNewDTO(CatalogacaoNewDTO dto) {
		return new Catalogacao( null, dto.getNome(),null, dto.getHoraInicio(), dto.getHoraFim());
		
	}

}
