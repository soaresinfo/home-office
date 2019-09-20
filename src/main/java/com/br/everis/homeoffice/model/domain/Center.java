/**
 * 
 */
package com.br.everis.homeoffice.model.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

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
@Table(name = "center")
@JsonTypeName(value = "center")
public class Center {

	@Id                                                                              
	@GeneratedValue(strategy = GenerationType.IDENTITY)    
	@JsonProperty
	private Long idCenter;
	
	@Column
	@JsonProperty
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column	
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
	private LocalDateTime registrationDate;
	
	@Column
	@JsonProperty
	private String country;
	
	@Column
	@JsonProperty
	private String state;
	
	@Column
	@JsonProperty
	private String city;
}
