package com.virax.restapi.contact_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virax.restapi.contact_api.model.Developer;
import com.virax.restapi.contact_api.service.DeveloperService;

@RestController
@RequestMapping("/api/developers")
public class DeveloperController {

    @Autowired
    private DeveloperService developerService;

    @PostMapping("/add")
    public ResponseEntity<Developer> addDeveloper(@RequestBody Developer developer) {
        return new ResponseEntity<>(developerService.addDeveloper(developer), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Developer>> getAllDevelopers() {
        return new ResponseEntity<>(developerService.getAllDevelopers(), HttpStatus.OK);
    }

    @GetMapping("/get/{userName}")
    public ResponseEntity<Developer> getDeveloperByUserName(@PathVariable String userName) {
        return new ResponseEntity<>(developerService.getDeveloperByUserName(userName), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDeveloper(@PathVariable int id) {
        developerService.deleteDeveloper(id);
        return new ResponseEntity<>("Developer deleted successfully! 🎉", HttpStatus.OK);
    }
}