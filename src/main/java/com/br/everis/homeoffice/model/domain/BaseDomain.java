package com.br.everis.homeoffice.model.domain;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author alan.franco
 *
 */
public abstract class BaseDomain implements Cloneable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8091792458180590060L;

	/**
	 * Constante criada para realizar a cobertura de log do código fonte.
	 */
	protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

}
