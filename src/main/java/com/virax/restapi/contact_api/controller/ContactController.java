package com.virax.restapi.contact_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.virax.restapi.contact_api.dtos.ContactDto;
import com.virax.restapi.contact_api.service.ContactOperations;

import io.swagger.v3.oas.annotations.Operation;

@CrossOrigin(origins = "*")
@RestController
public class ContactController {
	
	@Autowired
	ContactOperations co;
	
	@Operation(
			summary = "for adding new contaacts",
			description = "this required fileds of number,name,type and email"
	)
	@PostMapping("add/contact")
	public ResponseEntity<ContactDto> addContact(@RequestBody ContactDto contactDto) {
		return new ResponseEntity<>(co.addContact(contactDto),HttpStatus.CREATED);
	}
	
	@PostMapping("add/multi/contact")
	public ResponseEntity<List<ContactDto>> addMultipleContact(@RequestBody List<ContactDto> ip) {
		return new ResponseEntity<>(co.addMultipleContacts(ip),HttpStatus.MULTI_STATUS);
	}
	
	@GetMapping("get/contact/{mobileNumber}")
	public ResponseEntity<ContactDto> getContact(@PathVariable String mobileNumber) {
		return new ResponseEntity<>(co.getContactByMobileNumber(mobileNumber),HttpStatus.OK);
	}
	
	@GetMapping("get/all/contacts")
	public ResponseEntity<List<ContactDto>> gatAllContacts(){
		return new ResponseEntity<>(co.getAllContacts(),HttpStatus.OK);
	}
	
	@PutMapping("/update/name/{mobileNumber}")
	public ResponseEntity<String> updateName(@PathVariable String mobileNumber, @RequestBody String name) {
		co.updateContactName(mobileNumber, name);
		return new ResponseEntity<>("Name updated successfully!",HttpStatus.OK);
	}
	
	@PutMapping("/updateByNumber/{mobileNumber}")
	public ResponseEntity<String> updateContact(@PathVariable String mobileNumber, @RequestBody ContactDto c) {
		co.updateContact(mobileNumber, c);
		return new ResponseEntity<>("Contact updated successfully!",HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')") // for static user role based auth
	@DeleteMapping("/deleteByNumber/{mobileNumber}")
	public ResponseEntity<String> deleteContact(@PathVariable String mobileNumber) {
		co.deleteContactByMobileNumber(mobileNumber);
		return new ResponseEntity<>("Contact deleted successfully", HttpStatus.OK);
	}
	
	@GetMapping("/search/{key}")
	public ResponseEntity<List<ContactDto>> search(@PathVariable String key) {
		return new ResponseEntity<>(co.searchContacts(key),HttpStatus.OK);
	}
}
