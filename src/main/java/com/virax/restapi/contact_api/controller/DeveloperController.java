package com.virax.restapi.contact_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; // Consolidated imports

import com.virax.restapi.contact_api.dtos.DeveloperDto;
import com.virax.restapi.contact_api.service.DeveloperService;

@RestController
@RequestMapping("/api/developers")
public class DeveloperController {

    @Autowired
    private DeveloperService developerService;

    @PostMapping("/add")
    public ResponseEntity<DeveloperDto> addDeveloper(@RequestBody DeveloperDto developerDto) {
        return new ResponseEntity<>(developerService.addDeveloper(developerDto), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DeveloperDto> updateDeveloper(@PathVariable int id, @RequestBody DeveloperDto developerDto) {
        return new ResponseEntity<>(developerService.updateDeveloper(id, developerDto), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<DeveloperDto>> getAllDevelopers() {
        return new ResponseEntity<>(developerService.getAllDevelopers(), HttpStatus.OK);
    }

    @GetMapping("/get/{userName}")
    public ResponseEntity<DeveloperDto> getDeveloperByUserName(@PathVariable String userName) {
        return new ResponseEntity<>(developerService.getDeveloperByUserName(userName), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDeveloper(@PathVariable int id) {
        developerService.deleteDeveloper(id);
        return new ResponseEntity<>("Developer deleted successfully! 🎉", HttpStatus.OK);
    }
}