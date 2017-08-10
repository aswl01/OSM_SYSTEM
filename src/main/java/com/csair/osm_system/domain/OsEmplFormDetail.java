package com.csair.osm_system.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class OsEmplFormDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String level;

	private int peopleCount;

	private double peopleDay;

	private String workplace;

	private int seatNeeded;

	@Temporal(TemporalType.TIMESTAMP)
	private Date expectedArrival;

}
