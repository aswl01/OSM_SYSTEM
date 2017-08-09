package com.csair.osm_system.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csair.osm_system.domain.Attendence;
import com.csair.osm_system.service.AttendenceService;

@RestController
@RequestMapping(value = "/api/attendence")
public class AttendenceController {
	
	@Autowired
	private AttendenceService attendenceService;
	
	@RequestMapping(value="/signin/{code}")
	public void signIn(String code) {
		
		Attendence attend = new Attendence();
		
		attend.setSignIn(new Date());
		attend.setSignOut(new Date());
		
		attendenceService.signIn(code, attend);
		return;
	}
}
