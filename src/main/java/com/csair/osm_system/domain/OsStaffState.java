package com.csair.osm_system.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.csair.osm_system.model.Base;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name = "OS_Staff_State")
public class OsStaffState extends Base implements Serializable{

	private static final long serialVersionUID = 1657482478918094799L;

	@ManyToOne
	@JoinColumn(name="fk_os_staff_id")
	private OsStaff osStaff;
	
	@ManyToOne
	@JoinColumn(name="fk_proj_id")
	private Proj proj;
	
	@ManyToOne
	@JoinColumn(name="fk_os_pos_id")
	private OsPos osPos;
	
	private String level;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date enterDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date quitDate;
	
	private int duration;
	
	private boolean validation;
	
	@Column(length=255)
	private String comment;
	
}
