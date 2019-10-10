package com.br.everis.homeoffice.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.br.everis.homeoffice.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

/**
 * @author Marcelo
 *
 */
@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "PROFILE")
public class Professional extends AuditModel {

	@Id
	@Column(name = "ID_PROFISSIONAL")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private long idProfessional;
	
	@Column(name = "STATUS")
	private Status status;
	
	@Column(name = "REGISTRATION_DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime registrationDate;
	
	@Column(name = "HAS_NOTEBOOK")
	private Boolean hasNotebook;
	
	@Column(name = "TELEPHONE1")
	private String telephone1;

	@Column(name = "TELEPHONE2")
	private String telephone2;
	
	@ManyToOne
	@JoinColumn(name = "team_id", referencedColumnName = "ID_TEAM")
	private Team team;
}
