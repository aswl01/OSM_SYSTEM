package com.csair.osm_system.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.csair.osm_system.model.Base;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Leave_Appl")
@Getter
@Setter
public class LeaveAppl extends Base implements Serializable{

	private static final long serialVersionUID = 5193897768078558936L;

	@ManyToOne
	@JoinColumn(name="fk_os_staff_state_id")
	private OsStaffState osStaffState;

	@Temporal(TemporalType.TIMESTAMP)
	private Date startTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date endTime;
	
	private double days;
}