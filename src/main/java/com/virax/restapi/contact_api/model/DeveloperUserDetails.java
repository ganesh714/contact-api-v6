package com.virax.restapi.contact_api.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class DeveloperUserDetails implements UserDetails{

	private Developer developer;
	
	public DeveloperUserDetails(Developer developer) {
		this.developer = developer;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + "DEV"));
		
		return authorities;
	}

	@Override
	public String getPassword() {
		return developer.getPassward();
	}

	@Override
	public String getUsername() {
		return developer.getUserName();
	}

}
