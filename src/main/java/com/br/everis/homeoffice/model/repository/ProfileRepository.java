package com.br.everis.homeoffice.model.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.everis.homeoffice.model.domain.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long>, Serializable {

}
