package com.csair.osm_system.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.csair.osm_system.model.Base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "OT_Application")
public class OtApplication extends Base implements Serializable{

	private static final long serialVersionUID = -4718367051460636223L;

	@ManyToOne
	@JoinColumn(name="fk_os_staff_state_id")
	private OsStaffState osStaffState;
	
	@Column(length=255)
	private String content;
}
