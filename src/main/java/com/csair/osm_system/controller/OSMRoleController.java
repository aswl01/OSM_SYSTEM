package com.csair.osm_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csair.osm_system.domain.OSMRole;
import com.csair.osm_system.service.OSMRoleService;

@RestController
@RequestMapping("/api/roles")
public class OSMRoleController {
	
	@Autowired
	private OSMRoleService roleService;
	
	@PostMapping
	public OSMRole addOSM_Role(@RequestBody OSMRole osmRole) {
		return roleService.addOSMRole(osmRole);
	}
	
	@GetMapping
	public List<OSMRole> findAll() {
		return roleService.findAll();
	}
	
	@PutMapping(value = "/{id}")
	public OSMRole updateOSM_Role(@RequestBody OSMRole osmRole) {
		return roleService.updateOSMRole(osmRole);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteOSM_Role(@PathVariable long id) {
		roleService.deleteOSMRole(id);
	}

}
