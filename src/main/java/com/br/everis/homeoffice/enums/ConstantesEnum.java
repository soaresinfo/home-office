package com.br.everis.homeoffice.enums;

/**
 * @author alan.franco
 *
 */
public enum ConstantesEnum {

	SUFIXO_CONTROLLER("Controller"),
	SUFIXO_REPOSITORY("Repository"),
	SUFIXO_SERVICE("Service"),
	SUFIXO_SERVICE_FACHADA("ServiceFachada"),
	PREFIXO_LIQUIBASE("create-table-"),
	EXTENSAO_JAVA(".java"),
	EXTENSAO_XML(".xml");

	private String descricao;

	/**
	 * @param descricao
	 */
	ConstantesEnum(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return
	 */
	public String getDescricao() {
		return descricao;
	}
}
