package com.br.everis.homeoffice.model.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Table(name = "tb_evandro")
public class Country extends BaseDomain {

	private static final long serialVersionUID = -9158814171554795891L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "status")
	private Boolean status;

	@Column(name = "preco", precision = 18, scale = 3)
	private Double preco;

	@Column(name = "dataCadastro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;

}
