package com.br.everis.homeoffice.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.everis.homeoffice.model.domain.Professional;

/**
 * @author Marcelo
 *
 */
public interface ProfessionalRepository extends JpaRepository<Professional, Long> {

}
