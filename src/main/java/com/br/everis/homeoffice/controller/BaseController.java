package com.br.everis.homeoffice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author alan.franco
 *
 */
public abstract class BaseController {

	/**
	 * Constante criada para realizar a cobertura de log do código fonte.
	 */
	protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());
}
