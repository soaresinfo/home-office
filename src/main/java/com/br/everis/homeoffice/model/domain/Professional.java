package com.br.everis.homeoffice.model.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Marcelo
 *
 */
@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "professional")
public class Professional {

	@Id                                                                              
	@GeneratedValue(strategy = GenerationType.IDENTITY)                              
	private Long idProfessional; 
	
	@Column
	private Status status;
	
	@Column	
	private LocalDateTime registrationDate;
	
	@Column
	private Boolean hasNotebook;
	
	@Column
	private String telephone1;
	
	@Column
	private String telephone2;
	
	@ManyToOne
	@JoinColumn(name = "idTeam")
	private Team team;
}
