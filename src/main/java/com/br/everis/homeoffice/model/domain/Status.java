/**
 * 
 */
package com.br.everis.homeoffice.model.domain;

import lombok.Getter;

/**
 * @author Marcelo
 *
 */
public enum Status {
	ATIVO(1),
	INATIVO(2);
	
	@Getter
	private int status;
	
	private Status(int status) {
		this.status = status;
	}
}
