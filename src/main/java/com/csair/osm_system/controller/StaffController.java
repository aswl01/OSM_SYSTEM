package com.csair.osm_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	private ResponseEntity<Staff> responseByStaff(Staff staff) {
		HttpStatus status = staff == null ? HttpStatus.BAD_REQUEST : HttpStatus.OK;
		return new ResponseEntity<Staff>(staff, status);
	}
	
	@PostMapping
	public ResponseEntity<Staff> addStaff(@RequestBody Staff staff) {
		Staff response = null;
		try {
			response = staffService.addStaff(staff);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<Staff> entity = responseByStaff(response);
		return entity;
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
