package com.csair.osm_system.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csair.osm_system.domain.Proj;
import com.csair.osm_system.service.ProjService;

@RestController
@RequestMapping("/api/proj")
public class ProjController {
	
	@Autowired
	private ProjService projService;
	
	@PostMapping
	public Proj addProj(@RequestBody Proj proj) {
		return projService.addProj(proj);
	}
	
	@GetMapping
	public List<Proj> findAll() {
		return projService.findAll();
	}
	
	@GetMapping(value = "/details/{id}")
	public Set<Proj> findByStaff(@PathVariable long id) {
		return projService.findByStaff(id);
	}
	
	@PutMapping(value = "/details/{id}")
	public Proj updateProj(@RequestBody Proj proj) {
		return projService.updateProj(proj);
	}
	
	@DeleteMapping(value = "/details/{id}")
	public void deleteProj(@PathVariable long id) {
		projService.deleteProj(id);
	}

}
