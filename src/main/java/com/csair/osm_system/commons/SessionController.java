package com.csair.osm_system.commons;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csair.osm_system.domain.Staff;

@RestController
@RequestMapping("${uri.signin}")
public class SessionController {
	
	private Staff getCurrentStaff() {
		Authentication authentication =
				SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || !authentication.isAuthenticated()) {
			return null;
		}
		
		Object principal = authentication.getPrincipal();
		if (principal instanceof Staff) {
			return (Staff) principal;
		}
		
		return null;
	}
	
	private ResponseEntity<Staff> responseByStaff(Staff staff) {
		HttpStatus status = staff == null ? HttpStatus.UNAUTHORIZED : HttpStatus.OK;
		return new ResponseEntity<Staff>(staff, status);
	}
	
	@PostMapping
	public ResponseEntity<Staff> create() {
		Staff staff = getCurrentStaff();
		return responseByStaff(staff);
	}
	
	@GetMapping
	public ResponseEntity<Staff> fetch() {
		Staff staff = getCurrentStaff();
		return responseByStaff(staff);
	}

}
