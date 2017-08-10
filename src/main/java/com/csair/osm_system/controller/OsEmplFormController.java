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

import com.csair.osm_system.domain.OsEmplForm;
import com.csair.osm_system.service.OsEmplFormService;

@RestController
@RequestMapping("/api/applies")
public class OsEmplFormController {

	@Autowired
	private OsEmplFormService osEmplFormService;

	private ResponseEntity<OsEmplForm> responseByOsEmplForm(OsEmplForm osEmplForm) {
		HttpStatus status = osEmplForm == null ? HttpStatus.BAD_REQUEST : HttpStatus.OK;
		return new ResponseEntity<OsEmplForm>(osEmplForm, status);
	}

	@PostMapping
	public ResponseEntity<OsEmplForm> addOsEmplForm(@RequestBody OsEmplForm osEmplForm) {
		OsEmplForm response = null;
		try {
			response = osEmplFormService.addOsEmplForm(osEmplForm);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResponseEntity<OsEmplForm> entity = responseByOsEmplForm(response);
		return entity;
		
	}

	@GetMapping
	public List<OsEmplForm> findAll() {
		return osEmplFormService.findAll();
	}

	@GetMapping(value = "/prj/{id}")
	public List<OsEmplForm> findByStaff(@PathVariable long id) {
		return osEmplFormService.findByStaff(id);
	}

	@PutMapping(value = "/{id}")
	public OsEmplForm updateProj(@RequestBody OsEmplForm osEmplForm) {
		return osEmplFormService.updateOsEmplForm(osEmplForm);
	}

	@DeleteMapping(value = "/details/{id}")
	public void deleteOsEmplForm(@PathVariable long id) {
		osEmplFormService.deleteOsEmplForm(id);
	}

}
