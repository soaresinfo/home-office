package com.br.everis.homeoffice.model.service;

import java.io.File;
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author alan.franco
 *
 */
public abstract class BaseService {

	/**
	 * Constante criada para realizar a cobertura de log do código fonte.
	 */
	protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

	/**
	 * @param caminho
	 * @param nomeArq
	 * @param script
	 * @throws Exception
	 */
	public void gerarArquivo(String caminho, String nomeArq, String script) throws Exception {
		try {
			File arq = new File("src/main/resources/" + caminho + nomeArq);
			arq.createNewFile();
			PrintWriter gravarArq = new PrintWriter(arq);
			gravarArq.printf(script);
			gravarArq.close();
		} catch (Exception e) {
			LOGGER.error("Ocorreu um erro na Classe: BaseService >> gerarArquivo: " + e.getMessage());
			throw e;
		}
	}
}
