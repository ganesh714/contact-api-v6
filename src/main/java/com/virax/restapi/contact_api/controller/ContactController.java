package com.virax.restapi.contact_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@CrossOrigin(origins = "*")
@RestController
public class ContactController {
	
	@Autowired
	ContactOperations co;
	
	@PostMapping("add/contact")
	public boolean addContact(@RequestBody ContactDto contactDto) {
		return co.addContact(contactDto);
	}
	
	@PostMapping("add/multi/contact")
	public List<ContactDto> addMultipleContact(@RequestBody List<ContactDto> ip) {
		return co.addMultipleContacts(ip);
	}
	
	@GetMapping("get/contact/{mobileNumber}")
	public ContactDto getContact(@PathVariable String mobileNumber) {
		return co.getContactByMobileNumber(mobileNumber);
	}
	
	@GetMapping("get/all/contacts")
	public List<ContactDto> gatAllContacts(){
		return co.getAllContacts();
	}
	
	@PutMapping("/update/name/{mobileNumber}")
	public void updateName(@PathVariable String mobileNumber, @RequestBody String name) {
		co.updateContactName(mobileNumber, name);
	}
	
	@PutMapping("/updateByNumber/{mobileNumber}")
	public void updateContact(@PathVariable String mobileNumber, @RequestBody ContactDto c) {
		co.updateContact(mobileNumber, c);
	}
	
	@DeleteMapping("/deleteByNumber/{mobileNumber}")
	public void deleteContact(@PathVariable String mobileNumber) {
		co.deleteContactByMobileNumber(mobileNumber);
	}
	
	@GetMapping("/search/{key}")
	public List<ContactDto> search(@PathVariable String key) {
		return co.searchContacts(key);
	}
}
