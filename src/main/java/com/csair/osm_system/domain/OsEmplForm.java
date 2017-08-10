package com.csair.osm_system.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.csair.osm_system.model.Base;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "OS_Empl_Form")
public class OsEmplForm extends Base implements Serializable{

	private static final long serialVersionUID = -595018758948878335L;

	@ManyToOne
	@JoinColumn(name="fk_proj_id")
	private Proj proj;
	
	@OneToMany
	@JoinColumn(name="fk_details_id")
	Set<OsEmplFormDetail> osEmplFormDetails;

	@Temporal(TemporalType.TIMESTAMP)
	private Date applDate;
	
	private String applState;
	
}
