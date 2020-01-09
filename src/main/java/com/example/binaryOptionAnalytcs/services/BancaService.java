package com.example.binaryOptionAnalytcs.services;




import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.binaryOptionAnalytcs.dto.BancaDTO;
import com.example.binaryOptionAnalytcs.dto.BancaNewDTO;
import com.example.binaryOptionAnalytcs.entities.Banca;
import com.example.binaryOptionAnalytcs.entities.Cliente;
import com.example.binaryOptionAnalytcs.entities.Perfil;
import com.example.binaryOptionAnalytcs.enuns.MensagensEnum;
import com.example.binaryOptionAnalytcs.repositories.BancaRepository;
import com.example.binaryOptionAnalytcs.repositories.ClienteRepository;
import com.example.binaryOptionAnalytcs.repositories.MessageByLocaleRepository;
import com.example.binaryOptionAnalytcs.security.UsuarioSS;
import com.example.binaryOptionAnalytcs.services.exceptions.AuthorizationException;
import com.example.binaryOptionAnalytcs.services.exceptions.DataIntegrityException;
import com.example.binaryOptionAnalytcs.services.exceptions.ObjectNotFoundException;

@Service
public class BancaService {
	
	@Autowired
	private BancaRepository repository;
	@Autowired
	private ClienteRepository crepository;
	@Autowired
	private MessageByLocaleRepository messageSource;
	
	public List<Banca> findAll(){
		List <Banca> bancas = repository.findAll();
		
		return bancas;
	}
	public List<Banca> findAllByCliente(Long id){
		
		UsuarioSS usuarioLogado = UserService.authenticado();
		
		if((usuarioLogado == null || !id.equals(usuarioLogado.getId())&& !usuarioLogado.hasHole(Perfil.ADMIN))) {
			throw new AuthorizationException(messageSource.getMessage(MensagensEnum.USUARIO_NAO_AUTORIZADO.getMenssagem()));
		}
		Optional<Cliente> c = crepository.findById(id);
		
		if(c==null) {
			
			Object [] args = new Object[2];
			args[0]=id;
			args[1]= Cliente.class.getName();
			
			throw  new ObjectNotFoundException( messageSource.getMessage(MensagensEnum.TIPO_NAO_ENCONTRADO.getMenssagem(),args));
		}
		
		List <Banca> bancas = repository.FindAllByCliente(id);
		
		return bancas;
	}
	
	
	public Banca findById(Long id) {
		Optional<Banca> banca = repository.findById(id);
		
		Object [] args = new Object[2];
		args[0]=id;
		args[1]= Banca.class.getName();
					
		return banca.orElseThrow(() -> new ObjectNotFoundException( messageSource.getMessage(MensagensEnum.TIPO_NAO_ENCONTRADO.getMenssagem(),args)));
		
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
			throw new DataIntegrityException(messageSource.getMessage(MensagensEnum.ERRO_DELETAR_BANCA.getMenssagem()));
		}
	}
	
	public Banca fromDTO(BancaDTO dto) {
	
		return new Banca(dto.getId(), dto.getValorInicial(), dto.getValorAtual(), dto.getStopGain(), 
							dto.getStopLoss(), dto.getDataCriacao(),dto.getNome());
		
	}
	public Banca fromNewDTO( BancaNewDTO dto) {
		
		Banca banca = new Banca(null,dto.getValorInicial(), dto.getValorAtual(), dto.getStopGain(), dto.getStopLoss(), Instant.now(), dto.getNome());
		banca.getClienteBanca().setId(dto.getIdCliente());
		return banca;
	}
	

}
