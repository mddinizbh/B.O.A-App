package com.example.binaryOptionAnalytcs.services;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.binaryOptionAnalytcs.dto.BancaDTO;
import com.example.binaryOptionAnalytcs.entities.Banca;
import com.example.binaryOptionAnalytcs.repositories.BancaRepository;
import com.example.binaryOptionAnalytcs.services.exceptions.DataIntegrityException;
import com.example.binaryOptionAnalytcs.services.exceptions.ObjectNotFoundException;

@Service
public class BancaService {
	
	@Autowired
	BancaRepository repository;
	
	
	public List<Banca> findAll(){
		List <Banca> bancas = repository.findAll();
		
		return bancas;
	}
	
	public Banca findById(Long id) {
		Optional<Banca> banca = repository.findById(id);
		
		return banca.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Banca.class.getName()));
		
	}
	
	public Page<Banca> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),
				orderBy);
		
		return repository.findAll(pageRequest);
	}
	public Banca insert(Banca obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Banca update(Banca obj) {
	
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
	
	public Banca fromDTO(BancaDTO dto) {
	
		return new Banca(dto.getId(), dto.getValorInicial(), dto.getValorAtual(), dto.getStopGain(), 
							dto.getStopLoss(), dto.getDataCriacao(),dto.getNome());
		
	}

}
