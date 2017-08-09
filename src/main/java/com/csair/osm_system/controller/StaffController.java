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

import com.csair.osm_system.domain.Staff;
import com.csair.osm_system.service.StaffService;

@RestController
@RequestMapping("/api/staffs")
public class StaffController {
	
	@Autowired
	private StaffService staffService;
	
	@PostMapping
	public Staff addStaff(@RequestBody Staff staff) {
		return staffService.addStaff(staff);
	}
	
	@GetMapping
	public List<Staff> findAll() {
		return staffService.findAll();
	}
	
	@PutMapping(value = "/{id}")
	public Staff updateStaff(@RequestBody Staff staff) {
		return staffService.updateStaff(staff);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteStaff(@PathVariable long id) {
		staffService.deleteStaff(id);
	}

}
