package com.example.binaryOptionAnalytcs.config;



import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.binaryOptionAnalytcs.entities.Aporte;
import com.example.binaryOptionAnalytcs.entities.Banca;
import com.example.binaryOptionAnalytcs.entities.Catalogacao;
import com.example.binaryOptionAnalytcs.entities.DayTrade;
import com.example.binaryOptionAnalytcs.entities.Estrategia;
import com.example.binaryOptionAnalytcs.entities.EstrategiaCatalog;
import com.example.binaryOptionAnalytcs.entities.ParMoeda;
import com.example.binaryOptionAnalytcs.entities.Retirada;
import com.example.binaryOptionAnalytcs.entities.Trade;
import com.example.binaryOptionAnalytcs.entities.Usuario;
import com.example.binaryOptionAnalytcs.repositories.AporteRepository;
import com.example.binaryOptionAnalytcs.repositories.BancaRepository;
import com.example.binaryOptionAnalytcs.repositories.CatalogacaoRepository;
import com.example.binaryOptionAnalytcs.repositories.DayTradeRepository;
import com.example.binaryOptionAnalytcs.repositories.EstrategiaCatalogRepository;
import com.example.binaryOptionAnalytcs.repositories.EstrategiaRepository;
import com.example.binaryOptionAnalytcs.repositories.ParMoedaRepository;
import com.example.binaryOptionAnalytcs.repositories.RetiradaRepository;
import com.example.binaryOptionAnalytcs.repositories.TradeRepository;
import com.example.binaryOptionAnalytcs.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
   
	
	private Long random;
	
	@Autowired
	private EstrategiaRepository estRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private AporteRepository aporteRepository;

	@Autowired
	private RetiradaRepository retiradaRepository;

	@Autowired
	private EstrategiaCatalogRepository estrategiaCatalogRepository;

	@Autowired
	private BancaRepository bancaRepository;

	@Autowired
	private DayTradeRepository dayTradeRepository;

	@Autowired
	private TradeRepository tradeRepository;

	@Autowired
	private CatalogacaoRepository catalogacaoRepository;
	
	@Autowired
	private ParMoedaRepository ParMoedaRepository;

	@Autowired
	public Usuario populadorUsuario() {
		Usuario usuario = new Usuario();
		usuario.setId(null);
		usuario.setDataCriacao(Instant.now());
		usuario.setLogin("usuario"+random);
		usuario.setEmail("usuario"+random+"@gmail.com");
		usuario.setSenha("senha"+random);
		usuario.setNome("Nome "+ random);
				
		return usuario;
	}
	
	public Banca populadorBanca (Usuario usu) {
		Banca banca = new Banca();
		banca.setId(null);
		banca.setUsuarioBanca(usu);
		banca.setDataCricao(Instant.now());
		banca.setValorInicial(random*1000);
		banca.setValorAtual(banca.getValorInicial());
		banca.setNome("banca "+random);
		banca.setStopGain(random);
		banca.setStopLoss(random);
		return banca;
	}
	public ParMoeda populadorParMoeda() {
		ParMoeda par = new ParMoeda();
		par.setId(null);
		par.setNome(random+"/"+random+1);
		
		return par;
	}
	
	public Estrategia populadorEstrategia() {
		Estrategia estrategia = new Estrategia();
		estrategia.setId(null);
		estrategia.setDescricao("Desc. Estrategia "+random);
		estrategia.setNome("Estrategia "+random);
				
		return estrategia;
		
	}
	public EstrategiaCatalog populadorEstrategiaCatalogEstrategia(Catalogacao cat,Estrategia est) {
		
		EstrategiaCatalog estrategiaCatalog = new EstrategiaCatalog();
		estrategiaCatalog.setId(null);
		estrategiaCatalog.setCatalogacao(cat);
		estrategiaCatalog.setEstrategia(est);
		estrategiaCatalog.setQtdOperacaoes(random);
		estrategiaCatalog.setQtdMGs(estrategiaCatalog.getQtdOperacaoes()/4);
		estrategiaCatalog.setQtdLose(estrategiaCatalog.getQtdOperacaoes()/4);
		estrategiaCatalog.setQtdWin(estrategiaCatalog.getQtdOperacaoes()/4);
		estrategiaCatalog.setQtdMG(estrategiaCatalog.getQtdOperacaoes()/4);
				
		return estrategiaCatalog;
		
	}
	
	public Aporte populadorAporte(Banca banca) {
		
		Aporte aporte = new Aporte();
		
		aporte.setId(null);
		aporte.setBancaResp(banca);
		aporte.setDataAporte(LocalDate.now());
		aporte.setValorAporte(random);
			
		return aporte;
	}
	
	public Retirada populadorRetirada(Banca banca) {
		
		Retirada retirada = new Retirada();
		retirada.setId(null);
		retirada.setBancaResp(banca);
		retirada.setDataRetirada(Instant.now());
		retirada.setValorRetirada(random);
		retirada.setDescricao("Retirada valor: "+random);
		
		return retirada;
	}
	
	public Catalogacao populadorCatalogacao (Usuario usuario, ParMoeda par) {
		
		Catalogacao catalogacao = new Catalogacao();
		
		catalogacao.setId(null);
		catalogacao.setUsuarioCatalog(usuario);
		catalogacao.setParMoeda(par);
		catalogacao.setNome("Catalogacao "+ random);
		catalogacao.setData(LocalDate.now());
		catalogacao.setHoraInicioCatalog(LocalDate.now());
		catalogacao.setHorafimCatalog(LocalDate.now());
		
		return catalogacao;
		
	}
	
	
	public DayTrade populadorDayTrade (Banca banca){
		
		DayTrade dayTrade = new DayTrade();
		
		dayTrade.setId(null);
		dayTrade.setBancaResp(banca);
		dayTrade.setData(Instant.now());
		dayTrade.setValorPorc(random);
		dayTrade.setValorReal(random*100);
		
		return dayTrade;
		
		
	}
	
	public Trade populadorTrade (DayTrade dayTrade,Estrategia est, int param) {
		
		Trade trade= new Trade();
		
		trade.setId(null);
		trade.setDayTrade(dayTrade);
		trade.setEstrategiaTrade(est);
		trade.setValorAposta(random*param);
		trade.setValorPayOut(random);
		if(Math.random()*10 >= 5) {
			trade.setTradeStatus('W');
		}else {
			trade.setTradeStatus('L');
		}
		if (trade.getTradeStatus() == 'W') {
			trade.setValorResultado(trade.getValorAposta()*trade.getValorPayOut());
		}else {
			trade.setValorResultado(trade.getValorAposta()*-1);
		}
			
		
		
		return trade;
	}
	
	public Long getRandom() {
		return random;
	}

	public void setRandom(Long param) {
		this.random = (long) (Math.random()*param*100) ;
	}
 	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("tesando app");
		
		List <Usuario> usus = new ArrayList<Usuario>();
		List <Banca> bancas = new ArrayList<Banca>();
		List <Catalogacao> cats = new ArrayList<Catalogacao>();
		List <EstrategiaCatalog> estsCats = new ArrayList<EstrategiaCatalog>();
		List <DayTrade> dts = new ArrayList<DayTrade>();
		List <Aporte> aportes = new ArrayList<Aporte>();
		List <Retirada> retiradas = new ArrayList<Retirada>();
		List <Estrategia> ests = new ArrayList<Estrategia>();
		List <ParMoeda> pars = new ArrayList<ParMoeda>();
		List <Trade> trades = new ArrayList<Trade>(); 
		
		for (int i = 0; i<10;i++) {
			setRandom((long) i);
			usus.add(populadorUsuario());
			ests.add(populadorEstrategia());
			
			bancas.add(populadorBanca(usus.get(i)));
			aportes.add(populadorAporte(bancas.get(i)));
			retiradas.add(populadorRetirada(bancas.get(i)));
			
			dts.add(populadorDayTrade(bancas.get(i)));
			for(int y = 0; y<5;y++) {
				trades.add(populadorTrade(dts.get(i), ests.get(i),y));
			}
					
			pars.add(populadorParMoeda());
			cats.add(populadorCatalogacao(usus.get(i),pars.get(i)));
			estsCats.add(populadorEstrategiaCatalogEstrategia(cats.get(i),ests.get(i)));
					
		}
		
		usuarioRepository.saveAll(usus);
		estRepository.saveAll(ests);
		
		bancaRepository.saveAll(bancas);
		aporteRepository.saveAll(aportes);
		retiradaRepository.saveAll(retiradas);
		
		dayTradeRepository.saveAll(dts);
		tradeRepository.saveAll(trades);
		ParMoedaRepository.saveAll(pars);
		catalogacaoRepository.saveAll(cats);
		estrategiaCatalogRepository.saveAll(estsCats);
		
		
		
	}
}
	
