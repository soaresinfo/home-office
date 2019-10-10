package com.br.everis.homeoffice.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.everis.homeoffice.model.entity.Team;

/**
 * @author Marcelo
 *
 */
public interface TeamRepository extends JpaRepository<Team, Long> {

}
