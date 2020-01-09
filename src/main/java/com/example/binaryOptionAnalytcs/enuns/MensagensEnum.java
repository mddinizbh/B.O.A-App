package com.example.binaryOptionAnalytcs.enuns;

public enum MensagensEnum {
	
		PREENCHIMENTO_OBRIGATORIO ("preenchimento.obrigatorio"),
		VALOR_MAIOR_ZERO("valor.maior.zero"),
		EMAIL_INVALIDO("email.invalid"),
		SENHA_INVALIDA("senha.invalid"),
		EMAIL_CADASTRADO("email.cadastrado"),
		LOGIN_CADASTRADO("login.cadastrado"),
		TAMANHO_5A20("tamanho.5a20"),
		TAMANHO_5A80("tamanho.5a80"),
		ERRO_DELETAR_USUARIO("erro.deletar.usuario"),
		ERRO_DELETAR_BANCA("erro.deletar.banca"),
		ERRO_DELETAR_CATALOGACAO("erro.deletar.catalogacao"),
		ERRO_DELETAR_APORTE("erro.deletar.aporte"),
		ERRO_DELETAR_RETIRADA("erro.deletar.retirada"),
		ERRO_DELETAR_ESTRATEGIA("erro.deletar.estrategia"),
		ERRO_DELETAR_DAYTRADE("erro.deletar.daytrade"),
		ERRO_DELETAR_TRADE("erro.deletar.trade"),
		ERRO_DELETAR_ESTRATEGIA_CATOLOGACAO("erro.deletar.estrategiacatalogacao"),
		ERRO_DELETAR_PARMOEDA("erro.deletar.parmoeda"),
		
		
		
		
		TIPO_NAO_ENCONTRADO("tipo.naoencontrado"),
		USUARIO_NAO_AUTORIZADO("usuario.nao.autorizado");
		
		
		
		
		private String descricao;
		
		private MensagensEnum(String descricao) {
			this.descricao = descricao;
			getMenssagem();
		}

		public String getMenssagem() {
			return descricao;
		}
	
	
}
