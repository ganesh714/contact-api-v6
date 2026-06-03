package com.virax.restapi.contact_api.mappers;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.virax.restapi.contact_api.dtos.DeveloperDto;
import com.virax.restapi.contact_api.model.Developer;
import com.virax.restapi.contact_api.model.Role;

@Mapper(componentModel = "spring")
public interface DeveloperMapper {
	
	@Mapping(source = "roles", target = "roles")
	public Developer toDeveloper(DeveloperDto developerDto);
	
	public DeveloperDto toDeveloperDto(Developer developer);
	
//	List<Role> toRoles(List<Integer> roleIds){
//		
//	}
	default Set<Role> toRoles(Set<Integer> roleIds) {
		if (roleIds == null) {
			return null;
		}
		Set<Role> roles = new HashSet<Role>();
		for (Integer roleId:roleIds) {
			if (!(roleId == null)) {
				Role role = new Role();
				role.setId(roleId);
				roles.add(role);
	        }
		}
		return roles;
	}

	default Set<Integer> toRoleIds(Set<Role> roles) {
		if (roles == null) {
			return null;
		}
		Set<Integer> roleIds = new HashSet<Integer>();
		for (Role role : roles) {
			if (role != null) {
				roleIds.add(role.getId());
			}
		}
		return roleIds;
	}
}
