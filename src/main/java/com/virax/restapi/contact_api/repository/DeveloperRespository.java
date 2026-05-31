package com.virax.restapi.contact_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virax.restapi.contact_api.model.Developer;

public interface DeveloperRespository extends JpaRepository<Developer, Integer>{

	Developer findByUserName(String username);

}
