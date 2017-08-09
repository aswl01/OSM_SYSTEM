package com.csair.osm_system.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.csair.osm_system.model.Base;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class OsEmplFormDetail extends Base {

	@ManyToOne
	@JoinColumn(name = "fk_os_empl_id")
	private OsEmplForm osEmplForm;

	private String level;

	private int peopleCount;

	private double peopleDay;

	private String workplace;

	private int seatNeeded;

	@Temporal(TemporalType.TIMESTAMP)
	private Date expectedArrival;

}
