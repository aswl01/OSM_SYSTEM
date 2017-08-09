package com.csair.osm_system.test;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csair.osm_system.test.Applies;
import com.csair.osm_system.test.Attends;

@RestController
public class TestFrontEndController {
	
	@GetMapping
	@RequestMapping("/api/applies")
	public Applies TestFrontApplies() {
		Applies appl = new Applies();
		appl.setCount(1);
		appl.setDept("你猜");
		appl.setLevel("你再猜");
		appl.setPos("你真的猜");
		appl.setProj("我不说");
		return appl;
	}
	
	@PostMapping
	@RequestMapping("/api/attends")
	public Attends TestFrontAttends() {
		Attends attend = new Attends();
		attend.setState(0);
		attend.setTime(new Date());
		return attend;
	}
}
