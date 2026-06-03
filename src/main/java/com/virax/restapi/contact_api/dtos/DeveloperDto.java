package com.virax.restapi.contact_api.dtos;

import java.util.Set;

import lombok.Data;

@Data
public class DeveloperDto {
	private int id;
	private String userName;
	private String password;
	private Set<Integer> roles;
}
