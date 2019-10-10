package com.br.everis.homeoffice.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.everis.homeoffice.model.entity.Project;

/**
 * @author Marcelo
 *
 */
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
