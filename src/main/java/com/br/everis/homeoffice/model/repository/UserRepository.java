package com.br.everis.homeoffice.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.everis.homeoffice.model.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
