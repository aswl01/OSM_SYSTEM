package com.csair.osm_system.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.csair.osm_system.model.Base;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Table(name = "Total_Attend")
@Data
@EqualsAndHashCode(callSuper=true)
public class TotalAttend extends Base implements Serializable{

	private static final long serialVersionUID = -9047082244982683043L;

	@ManyToOne
	@JoinColumn(name="fk_os_staff_state_id")
	private OsStaffState osStaffState;
	
	private int personDays;
	
	private int lateDay;
	
	private int earlyDay;
	
	private Boolean comeOnSchedule;
	
	private double OtTime;

}
