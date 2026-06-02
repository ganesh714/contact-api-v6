package com.virax.restapi.contact_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.virax.restapi.contact_api.model.Developer;
import com.virax.restapi.contact_api.repository.DeveloperRespository;

@Service
public class DeveloperService {
	
	@Autowired
	DeveloperRespository developerRespository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public Developer addDeveloper(Developer developer) {
		if (developerRespository.findById(developer.getId()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.CONFLICT,"developer already exist");
		}
		else {
			String enPass = passwordEncoder.encode(developer.getPassward());
			developer.setPassward(enPass);
			return developerRespository.save(developer);
		}
	}
	public List<Developer> getAllDevelopers() {
        return developerRespository.findAll();
    }

    public Developer getDeveloperByUserName(String userName) {
        return developerRespository.findByUserName(userName);
    }
    
    public void deleteDeveloper(int id) {
        developerRespository.deleteById(id);
    }
}
