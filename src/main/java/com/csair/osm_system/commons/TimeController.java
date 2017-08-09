package com.csair.osm_system.commons;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/time")
public class TimeController {

	@GetMapping
	public String getDateTime() {
		return new Date().getTime() + "";
	}
}
