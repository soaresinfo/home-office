/**
 * 
 */
package com.br.everis.homeoffice.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import com.br.everis.homeoffice.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "TEAM")
public class Team extends AuditModel {

	@Id
	@Column(name = "ID_TEAM")
	@GeneratedValue(strategy = GenerationType.IDENTITY)                              
	private long idTeam;
	
	@Column(name = "STATUS")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(name = "REGISTRATION_DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime registrationDate;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "idProject" )
	private Project project;

	@OneToMany(mappedBy = "team")
	@Transient
	private List<Professional> professionals;
}
