package com.br.everis.homeoffice.model.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@ToString
@Entity
@Table(name = "tb_user")
public class User {


	@Id                                                                              
	@GeneratedValue(strategy = GenerationType.IDENTITY)                              
	private Long id; 
	
	@Column(name = "status")
	private Status status;
	
	@JsonProperty("registrationDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name = "registrationDate")
	private LocalDateTime registrationDate;
	
	@Column(name= "name")
	private String name	;
	
	@Column(name= "email")
	private String email;
	
	@Column(name= "motherName")
	private String motherName;
	
	@Column(name = "dateBirth")
	private LocalDateTime dateBirth;
	
	
}
