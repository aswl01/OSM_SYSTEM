package com.csair.osm_system.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csair.osm_system.domain.Attendence;
import com.csair.osm_system.dto.AttendsDto;
import com.csair.osm_system.dto.PushAttendRecordsDto;
import com.csair.osm_system.service.AttendenceService;

@RestController
@RequestMapping(value = "/api/attends")
public class AttendenceController {
	
	@Autowired
	private AttendenceService attendenceService;
	
	@PostMapping
	public void checkInAndOut(@RequestBody AttendsDto atd) {
		if (atd.getState() == 0) {
			attendenceService.checkIn(atd.getUserId());
		}
		else if (atd.getState() == 1) {
			attendenceService.checkOut(atd.getUserId());
		}
		return;
	}
	
	@GetMapping
	public List<PushAttendRecordsDto> recent10Records() {
		List<Attendence> L = attendenceService.findTop10OrderByCreateTimeDesc();
		List<PushAttendRecordsDto> ListOfDto = new ArrayList<>();
		for (Attendence record : L) {
			PushAttendRecordsDto dto = new PushAttendRecordsDto();
			if (record.getSignIn() != null) {//签到为0
				dto.setState(0);
				dto.setTime(record.getSignIn());
			}
			else if (record.getSignOut() != null) {//签退为1
				dto.setState(1);
				dto.setTime(record.getSignOut());
			}
			dto.setInformation("haha");
			ListOfDto.add(dto);
		}
		return ListOfDto;
	}
}
