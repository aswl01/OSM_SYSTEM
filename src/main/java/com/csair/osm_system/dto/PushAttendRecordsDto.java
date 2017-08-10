package com.csair.osm_system.dto;

import java.util.Date;

import lombok.Data;

@Data
public class PushAttendRecordsDto {
	private int state;
	private String information;
	private Date time;
}
