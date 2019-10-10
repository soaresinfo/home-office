package com.br.everis.homeoffice.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

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
@Table(name = "tb_country")
public class Country extends AuditModel {

	private static final long serialVersionUID = -9158814171554795891L;

	@Id
	@Column(name = "ID_COUNTRY", nullable = false, unique = true)
	@GeneratedValue
	private long idCountry;

	@Column(name = "DESCRIPTION", nullable = true)
	private String description;

	@Column(name = "STATUS", nullable = false)
	private Boolean status;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name = "REGISTRATION_DATE")
	private LocalDate registration_date;

}
