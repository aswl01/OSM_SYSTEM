package com.csair.osm_system.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.csair.osm_system.model.Base;
import com.csair.osm_system.model.trialFlag;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name = "OS_Staff_Eval")
public class OsStaffEval extends Base implements Serializable{

	private static final long serialVersionUID = 1493261641086512757L;

	@ManyToOne
	@JoinColumn(name="fk_os_staff_id")
	private OsStaff osStaff;
	
	@ManyToOne
	@JoinColumn(name="fk_proj_id")
	private Proj proj;

	private double overallRating;
	
	private Boolean osField;
	
	private Boolean projLeader;
	
	private Boolean deptManager;
	
	@Enumerated(EnumType.STRING)
	private trialFlag trialFlag;
	
	private Boolean result;

}
